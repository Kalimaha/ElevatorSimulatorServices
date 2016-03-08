from pymongo import MongoClient
from bson.objectid import ObjectId
from elevator_service.config.settings import production as p
from elevator_service.config.settings import test as t


class DAO:

    def __init__(self, username, password, host, port, db):
        self.username = username
        self.password = password
        self.host = host
        self.port = port
        self.db = db
        self.uri = self.create_connection_uri()
        self.client = MongoClient(self.uri)

    def get(self, collection_name):
        out = []
        db = self.client[self.db]
        collection = db[collection_name]
        items = collection.find()
        for item in items:
            out.append(item)
        return out

    # def get_by_id(self, collection_name, item_id):
    #     db = self.client[self.db]
    #     collection = db[collection_name]
    #     return collection.find_one({'_id': ObjectId(item_id)})

    def get_by_session_and_time(self, collection_name, session, time):
        out = []
        db = self.client[self.db]
        collection = db[collection_name]
        time = int(time)
        items = collection.find({'session': session, 'time': time})
        for item in items:
            out.append(item)
        return out

    def create(self, collection_name, item):
        db = self.client[self.db]
        collection = db[collection_name]
        print item
        print item['id']
        print item['session']
        print item['time']
        return collection.update_one({'id': item['id'], 'session': item['session'], 'time': item['time']}, {'$set': item}, upsert=True)

    # def delete(self, collection_name, item_id):
    #     db = self.client[self.db]
    #     collection = db[collection_name]
    #     return collection.remove({'_id': ObjectId(item_id)})

    # def update(self, collection_name, item_id, item):
    #     db = self.client[self.db]
    #     collection = db[collection_name]
    #     return collection.update({'_id': ObjectId(item_id)}, item, upsert=False)

    def create_connection_uri(self):
        return 'mongodb://' + self.username + ':' + self.password + '@' + self.host + ':' + self.port + '/' + self.db

    def drop_collection(self, collection_name):
        db = self.client[self.db]
        db.drop_collection(collection_name)


def get_dao(environment):
    if 'production' in environment:
        return DAO(p['username'], p['password'], p['host'], p['port'], p['db_name'])
    elif 'test' in environment:
        return DAO(t['username'], t['password'], t['host'], t['port'], t['db_name'])

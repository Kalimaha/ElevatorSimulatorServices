import json
import unittest
from flask import Flask
from elevator_service.core.dao import DAO
from elevator_service.core.dao import get_dao
from elevator_service.rest.elevators import elevators
from elevator_service.config.settings import test as t
from elevator_service.resources.test_elevator import elevator_1


class BooksTest(unittest.TestCase):

    def setUp(self):
        self.app = Flask(__name__)
        self.app.register_blueprint(elevators, url_prefix='/elevators')
        self.tester = self.app.test_client(self)
        dao = DAO(t['username'], t['password'], t['host'], t['port'], t['db_name'])
        dao.drop_collection('elevators')

    def tearDown(self):
        dao = DAO(t['username'], t['password'], t['host'], t['port'], t['db_name'])
        dao.drop_collection('elevators')

    def test_get(self):
        dao = get_dao('test')
        dao.create('elevators', elevator_1)
        response = self.tester.get('/elevators/test/', content_type='application/json')
        self.assertEquals(response.status_code, 200)
        data = json.loads(response.data)
        self.assertEquals(len(data), 1)

    def test_get_by_session_and_time(self):
        dao = get_dao('test')
        dao.create('elevators', elevator_1)
        response = self.tester.get('/elevators/test/alpha/1/', content_type='application/json')
        self.assertEquals(response.status_code, 200)
        data = json.loads(response.data)
        self.assertEquals(len(data), 1)

    def test_create(self):
        payload = json.dumps(elevator_1)
        print payload
        response = self.tester.post('/elevators/test/', data=payload, content_type='application/json')
        self.assertEquals(response.status_code, 200)
        dao = get_dao('test')
        items = dao.get('elevators')
        self.assertEqual(len(items), 1)

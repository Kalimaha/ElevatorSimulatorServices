import unittest
from elevator_service.core.dao import DAO
from elevator_service.core.dao import get_dao
from elevator_service.config.settings import test as t
from elevator_service.config.settings import production as p
from elevator_service.resources.test_elevator import elevator_1
from elevator_service.resources.test_elevator import elevator_2


class ElevatorServiceTest(unittest.TestCase):

    def setUp(self):
        dao = DAO(t['username'], t['password'], t['host'], t['port'], t['db_name'])
        dao.drop_collection('elevators')

    def tearDown(self):
        dao = DAO(t['username'], t['password'], t['host'], t['port'], t['db_name'])
        dao.drop_collection('elevators')

    def test_get_dao(self):
        dao = get_dao('production')
        self.assertEqual(dao.username, p['username'])
        self.assertEqual(dao.password, p['password'])
        self.assertEqual(dao.host, p['host'])
        self.assertEqual(dao.port, p['port'])
        self.assertEqual(dao.db, p['db_name'])
        dao = get_dao('test')
        self.assertEqual(dao.username, t['username'])
        self.assertEqual(dao.password, t['password'])
        self.assertEqual(dao.host, t['host'])
        self.assertEqual(dao.port, t['port'])
        self.assertEqual(dao.db, t['db_name'])

    def test_create_connection_uri(self):
        dao = get_dao('test')
        uri = dao.create_connection_uri()
        self.assertEqual(uri, 'mongodb://myer:Myer2016@ds023468.mlab.com:23468/elevatorsdatatest')

    def test_create_item(self):
        dao = get_dao('test')
        inserted_id = dao.create('elevators', elevator_1)
        self.assertIsNotNone(inserted_id)

    def test_get(self):
        dao = get_dao('test')
        dao.create('elevators', elevator_1)
        dao.create('elevators', elevator_2)
        items = dao.get('elevators')
        self.assertEqual(len(items), 2)

    def test_get_by_session_and_time(self):
        dao = get_dao('test')
        inserted_id = dao.create('elevators', elevator_1)
        items = dao.get_by_session_and_time('elevators', 'alpha', 1)
        self.assertEqual(len(items), 1)
        self.assertEqual(items[0]['session'], 'alpha')
        self.assertEqual(items[0]['time'], 1)
        items = dao.get_by_session_and_time('elevators', 'alpha', "1")
        self.assertEqual(len(items), 1)
        self.assertEqual(items[0]['session'], 'alpha')
        self.assertEqual(items[0]['time'], 1)
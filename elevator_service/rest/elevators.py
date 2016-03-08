import json
from flask import Response
from flask import request
from flask import Blueprint
from bson import json_util
from flask.ext.cors import CORS
from flask.ext.cors import cross_origin
from elevator_service.core.dao import get_dao


elevators = Blueprint('elevators', __name__)


@elevators.route('/<environment>/', methods=['GET'])
@cross_origin(origins='*', headers=['Content-Type'])
def get(environment):
    """
    All the available elevators documents
    :param environment: 'test' or 'production'
    :return: All the available elevators documents
    """
    dao = get_dao(environment)
    out = json.dumps(dao.get('elevators'), sort_keys=True, indent=4, default=json_util.default)
    return Response(out, content_type='application/json; charset=utf-8')


@elevators.route('/<environment>/<session>/<id>/', methods=['GET'])
@cross_origin(origins='*', headers=['Content-Type'])
def get_by_session_and_id(environment, session, id):
    """
    Fetch all the documents matching the given session ID and elevator's ID
    :param environment: 'test' or 'production'
    :param session: Session ID
    :param id: Elevator ID
    :return: All the matching documents
    """
    dao = get_dao(environment)
    out = json.dumps(dao.get_by_session_and_id('elevators', session, id), sort_keys=True, indent=4, default=json_util.default)
    return Response(out, content_type='application/json; charset=utf-8')


@elevators.route('/<environment>/', methods=['POST'])
@cross_origin(origins='*', headers=['Content-Type'])
def create(environment):
    """
    Add a new document to the DB
    :param environment: 'test' or 'production'
    :return: The result of the operation
    """
    item = json.loads(request.data)
    dao = get_dao(environment)
    ack = dao.create('elevators', item)
    out = json.dumps(ack, sort_keys=True, indent=4, default=json_util.default)
    return Response(out, content_type='application/json; charset=utf-8')
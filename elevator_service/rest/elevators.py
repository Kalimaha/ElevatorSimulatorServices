import json
from flask import Response
from flask import request
from flask import Blueprint
from bson import json_util
from elevator_service.core.dao import get_dao


books = Blueprint('elevators', __name__)


@books.route('/<environment>/', methods=['GET'])
def get(environment):
    dao = get_dao(environment)
    out = json.dumps(dao.get('elevators'), sort_keys=True, indent=4, default=json_util.default)
    return Response(out, content_type='application/json; charset=utf-8')


@books.route('/<environment>/<item_id>/', methods=['GET'])
def get_by_id(environment, item_id):
    dao = get_dao(environment)
    out = json.dumps(dao.get_by_id('elevators', item_id), sort_keys=True, indent=4, default=json_util.default)
    return Response(out, content_type='application/json; charset=utf-8')


@books.route('/<environment>/<item_id>/', methods=['DELETE'])
def delete(environment, item_id):
    dao = get_dao(environment)
    out = json.dumps(dao.delete('elevators', item_id), sort_keys=True, indent=4, default=json_util.default)
    return Response(out, content_type='application/json; charset=utf-8')


@books.route('/<environment>/<item_id>/', methods=['PUT'])
def update(environment, item_id):
    item = json.loads(request.data)
    dao = get_dao(environment)
    ack = dao.update('elevators', item_id, item)
    out = json.dumps(ack, sort_keys=True, indent=4, default=json_util.default)
    return Response(out, content_type='application/json; charset=utf-8')


@books.route('/<environment>/', methods=['POST'])
def create(environment, item_id):
    item = json.loads(request.data)
    dao = get_dao(environment)
    ack = dao.create('elevators', item)
    out = json.dumps(ack, sort_keys=True, indent=4, default=json_util.default)
    return Response(out, content_type='application/json; charset=utf-8')
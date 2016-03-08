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
    dao = get_dao(environment)
    out = json.dumps(dao.get('elevators'), sort_keys=True, indent=4, default=json_util.default)
    return Response(out, content_type='application/json; charset=utf-8')


@elevators.route('/<environment>/<session>/<id>/', methods=['GET'])
@cross_origin(origins='*', headers=['Content-Type'])
def get_by_session_and_id(environment, session, id):
    dao = get_dao(environment)
    out = json.dumps(dao.get_by_session_and_id('elevators', session, id), sort_keys=True, indent=4, default=json_util.default)
    return Response(out, content_type='application/json; charset=utf-8')


@elevators.route('/<environment>/', methods=['POST'])
@cross_origin(origins='*', headers=['Content-Type'])
def create(environment):
    item = json.loads(request.data)
    dao = get_dao(environment)
    ack = dao.create('elevators', item)
    out = json.dumps(ack, sort_keys=True, indent=4, default=json_util.default)
    return Response(out, content_type='application/json; charset=utf-8')
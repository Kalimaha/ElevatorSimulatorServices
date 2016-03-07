import json
from flask import Flask
from bson import json_util
from elevator_service.rest.elevators import elevators


app = Flask(__name__)
app.register_blueprint(elevators, url_prefix='/elevators')


# @app.route('/', methods=['GET'])
# def json_schema_service():
#     return json.dumps(schema, sort_keys=True, indent=4, default=json_util.default), \
#            200, \
#            {'Content-Type': 'application/schema+json; charset=utf-8'}


if __name__ == '__main__':
    app.run()
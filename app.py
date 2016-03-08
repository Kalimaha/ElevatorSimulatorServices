from flask import Flask
from flask.ext.cors import CORS
from elevator_service.rest.elevators import elevators


app = Flask(__name__)
cors = CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'
app.register_blueprint(elevators, url_prefix='/elevators')


if __name__ == '__main__':
    app.run()

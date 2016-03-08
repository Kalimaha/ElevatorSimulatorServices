from flask import Flask
from flask.ext.cors import CORS
from elevator_service.rest.elevators import elevators


# Initiate Flask framework
app = Flask(__name__)

# Initiate and configure CORS filters
cors = CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'

# Register the elevators blueprint
app.register_blueprint(elevators, url_prefix='/elevators')


if __name__ == '__main__':
    app.run()

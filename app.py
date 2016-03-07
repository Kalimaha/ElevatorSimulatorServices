from flask import Flask
from elevator_service.rest.elevators import elevators


app = Flask(__name__)
app.register_blueprint(elevators, url_prefix='/elevators')


if __name__ == '__main__':
    app.run()

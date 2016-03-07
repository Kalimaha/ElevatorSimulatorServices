from setuptools import setup
from setuptools import find_packages

setup(
    name='ElevatorSimulatorService',
    version='0.1.0',
    author='Guido Barbaglia',
    author_email='guido.barbaglia@gmail.com',
    packages=find_packages(),
    license='LICENSE.txt',
    description='Services for the Elevator Simulator project.',
    install_requires=[
        'watchdog', 'flask', 'gunicorn', 'pymongo'
    ],
    url='http://pypi.python.org/pypi/ElevatorSimulatorService/'
)
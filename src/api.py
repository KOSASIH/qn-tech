# src/api.py

from flask import Flask, jsonify, request
from .transaction import Transaction

app = Flask(__name__)

@app.route('/transaction', methods=['POST'])
def create_transaction():
    data = request.get_json()
    transaction = Transaction(data['sender'], data['receiver'], data['amount'])
    transaction.process()
    return jsonify({'status': 'Transaction created'}), 201

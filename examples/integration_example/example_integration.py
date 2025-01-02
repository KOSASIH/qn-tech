import requests
import json

# Configuration
API_URL = "http://localhost:8080/qntech/api"
API_KEY = "your_api_key_here"  # Replace with your actual API key

def get_user_data(user_id):
    """Fetch user data from the API."""
    response = requests.get(f"{API_URL}/users/{user_id}", headers={"Authorization": f"Bearer {API_KEY}"})
    if response.status_code == 200:
        return response.json()
    else:
        print(f"Error fetching user data: {response.status_code} - {response.text}")
        return None

def create_transaction(user_id, amount):
    """Create a new transaction for a user."""
    transaction_data = {
        "user_id": user_id,
        "amount": amount,
        "transaction_date": "2023-10-07",
        "status": "pending"
    }
    response = requests.post(f"{API_URL}/transactions", json=transaction_data, headers={"Authorization": f"Bearer {API_KEY}"})
    if response.status_code == 201:
        print("Transaction created successfully:", response.json())
    else:
        print(f"Error creating transaction: {response.status_code} - {response.text}")

if __name__ == "__main__":
    user_id = 101  # Example user ID
    user_data = get_user_data(user_id)
    if user_data:
        print("User  Data:", json.dumps(user_data, indent=4))
        create_transaction(user_id, 150.00)

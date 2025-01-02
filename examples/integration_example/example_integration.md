# Example Integration with QN-Tech

This document provides an example of how to integrate with the QN-Tech API using Python.

## Prerequisites

- Python 3.x
- `requests` library (install via `pip install requests`)

## Configuration

Before running the script, make sure to update the following variables in `example_integration.py`:

- `API_URL`: The base URL of your QN-Tech API (e.g., `http://localhost:8080/qntech/api`).
- `API_KEY`: Your API key for authentication.

## Script Overview

The script demonstrates two main functionalities:

1. **Fetching User Data**: The `get_user_data(user_id)` function retrieves user information from the API.
2. **Creating a Transaction**: The `create_transaction(user_id, amount)` function creates a new transaction for a specified user.

## Usage

1. Clone the repository and navigate to the `examples/integration_example` directory.
2. Update the configuration in `example_integration.py`.
3. Run the script:


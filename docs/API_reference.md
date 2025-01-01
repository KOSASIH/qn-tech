# API Reference

This document provides a comprehensive reference for the APIs available in the QN-Tech project. Each API endpoint is described with its purpose, request parameters, response format, and examples.

## Base URL

https://api.qntech.example.com/v1


## Authentication
All API requests require authentication. Use the following header for authentication:

```
Authorization: Bearer <your_access_token>
```


## Endpoints

### 1. Quantum Encryption

#### POST /encrypt
Encrypts data using quantum encryption methods.

**Request Body:**
```json
1 {
2   "data": "string",
3   "encryptionMethod": "string" // e.g., "QKD", "PQC"
4 }
```

**Response:**

- 200 OK

```json
1 {
2   "encryptedData": "string"
3 }
```

- 400 Bad Request

```json
1 {
2   "error": "Invalid input"
3 }
```

**Example:**

```bash
1 curl -X POST https://api.qntech.example.com/v1/encrypt \
2 -H "Authorization: Bearer YOUR_ACCESS_TOKEN" \
3 -H "Content-Type: application/json" \
4 -d '{"data": "Hello, World!", "encryptionMethod": "QKD"}'
```

2. Data Analytics
**GET** /analytics
Retrieves analytics data based on specified parameters.

**Query Parameters:**

- startDate (required): The start date for the analytics (format: YYYY-MM-DD).
- endDate (required): The end date for the analytics (format: YYYY-MM-DD).

**Response:**

- **200** OK

```json
1 {
2   "analytics": [
3     {
4       "date": "YYYY-MM-DD",
5       "value": "number"
6     }
7   ]
8 }
```

- **404** Not Found

```json
1 {
2   "error": "No data found for the specified date range"
3 }
```

**Example**

```bash
1 curl -X GET "https://api.qntech.example.com/v1/analytics?startDate=2023-01-01&endDate=2023-01-31" \
2 -H "Authorization: Bearer YOUR_ACCESS_TOKEN"
```

3. Smart Contracts

- **POST** /contracts
- Creates a new smart contract.

**Request Body:**

```json
1 {
2   "contractData": {
3     "title": "string",
4     "terms": "string",
5     "parties": ["string"]
6   }
7 }
```

**Response:**

**201** Created

```json
1 {
2   "contractId": "string",
3   "status": "created"
4 }
```

- **400** Bad Request

```json
1 {
2   "error": "Invalid contract data"
3 }
```

**Example:**

```bash
1 curl -X POST https://api.qntech.example.com/v1/contracts \
2 -H "Authorization: Bearer YOUR_ACCESS_TOKEN" \
3 -H "Content-Type: application/json" \
4 -d '{"contractData": {"title": "Partnership Agreement", "terms": "Terms of the agreement", "parties": ["Party A", "Party B"]}}'
```

## Error Codes

- **400**: Bad Request - The request was invalid.
- **401**: Unauthorized - Authentication failed.
- **404**: Not Found - The requested resource was not found.
- **500**: Internal Server Error - An error occurred on the server.

## Rate Limiting
API requests are limited to 100 requests per minute. Exceeding this limit will result in a 429 Too Many Requests response.

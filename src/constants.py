# src/constants.py

"""
Pi Coin Configuration Constants
This module contains constants related to the Pi Coin cryptocurrency.
"""

import os
from datetime import datetime, timedelta

# Pi Coin Symbol
PI_COIN_SYMBOL: str = "Pi"  # Symbol for Pi Coin

# Pi Coin Value
PI_COIN_VALUE: float = 314159.00  # Fixed value of Pi Coin in USD

# Pi Coin Supply
PI_COIN_SUPPLY: int = 100_000_000_000  # Total supply of Pi Coin

# Pi Coin Transaction Fee
PI_COIN_TRANSACTION_FEE: float = 0.01  # Transaction fee in USD

# Pi Coin Block Time
PI_COIN_BLOCK_TIME: int = 10  # Average block time in seconds

# Pi Coin Mining Difficulty
PI_COIN_MINING_DIFFICULTY: int = 1000  # Difficulty level for mining Pi Coin

# Pi Coin Reward for Mining
PI_COIN_MINING_REWARD: float = 12.5  # Reward for mining a block

# Pi Coin Network Protocol
PI_COIN_NETWORK_PROTOCOL: str = "PoS"  # Proof of Stake

# Pi Coin Maximum Transaction Size
PI_COIN_MAX_TRANSACTION_SIZE: int = 1_000_000  # Maximum transaction size in bytes

# Pi Coin Decimals
PI_COIN_DECIMALS: int = 18  # Number of decimal places for Pi Coin

# Pi Coin Genesis Block Timestamp
PI_COIN_GENESIS_BLOCK_TIMESTAMP: datetime = datetime(2025, 1, 1, 0, 0, 0)  # Timestamp of the genesis block

# Pi Coin Governance Model
PI_COIN_GOVERNANCE_MODEL: str = "Decentralized"  # Governance model for Pi Coin

# Pi Coin Security Features
PI_COIN_ENCRYPTION_ALGORITHM: str = "AES-256"  # Encryption algorithm for securing transactions
PI_COIN_HASHING_ALGORITHM: str = "SHA-256"  # Hashing algorithm for block verification
PI_COIN_SIGNATURE_SCHEME: str = "ECDSA"  # Digital signature scheme for transaction signing

# Pi Coin Network Parameters
PI_COIN_MAX_PEERS: int = 100  # Maximum number of peers in the network
PI_COIN_NODE_TIMEOUT: int = 30  # Timeout for node responses in seconds
PI_COIN_CONNECTION_RETRY_INTERVAL: int = 5  # Retry interval for node connections in seconds

# Pi Coin Staking Parameters
PI_COIN_MIN_STAKE_AMOUNT: float = 100.0  # Minimum amount required to stake
PI_COIN_STAKE_REWARD_RATE: float = 0.05  # Annual reward rate for staking

# Pi Coin API Rate Limits
PI_COIN_API_REQUEST_LIMIT: int = 1000  # Maximum API requests per hour
PI_COIN_API_KEY_EXPIRATION: int = 3600  # API key expiration time in seconds

# Pi Coin Regulatory Compliance
PI_COIN_KYC_REQUIRED: bool = True  # Whether KYC is required for transactions
PI_COIN_COMPLIANCE_JURISDICTIONS: list[str] = ["US", "EU", "UK"]  # Jurisdictions for compliance

# Environment Variables for Sensitive Data
PI_COIN_DB_CONNECTION_STRING: str = os.getenv("PI_COIN_DB_CONNECTION_STRING", "default_connection_string")
PI_COIN_API_SECRET_KEY: str = os.getenv("PI_COIN_API_SECRET_KEY", "default_secret_key")

# Advanced Security Features
PI_COIN_USE_TWO_FACTOR_AUTH: bool = True  # Enable two-factor authentication for transactions
PI_COIN_MAX_FAILED_LOGIN_ATTEMPTS: int = 5  # Maximum failed login attempts before lockout
PI_COIN_LOCKOUT_DURATION: timedelta = timedelta(minutes=15)  # Duration of lockout after failed attempts

# Additional constants can be added here as needed

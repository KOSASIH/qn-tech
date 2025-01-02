import os
import json
import logging
import yaml
from dotenv import load_dotenv
from jsonschema import validate, ValidationError
from pathlib import Path

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

class ConfigManager:
    def __init__(self, config_file=None, schema_file=None):
        """
        Initialize the ConfigManager.

        :param config_file: Path to the configuration file (YAML, JSON, or .env).
        :param schema_file: Path to the JSON schema file for validation.
        """
        self.config = {}
        self.schema = {}
        self.load_env_variables()
        if config_file:
            self.load_config_file(config_file)
        if schema_file:
            self.load_schema(schema_file)

    def load_env_variables(self):
        """Load environment variables from a .env file."""
        load_dotenv()
        logging.info("Environment variables loaded.")

    def load_config_file(self, config_file):
        """Load configuration from a specified file."""
        try:
            if config_file.endswith('.yaml') or config_file.endswith('.yml'):
                with open(config_file, 'r') as file:
                    self.config = yaml.safe_load(file)
                    logging.info(f"Configuration loaded from {config_file}.")
            elif config_file.endswith('.json'):
                with open(config_file, 'r') as file:
                    self.config = json.load(file)
                    logging.info(f"Configuration loaded from {config_file}.")
            elif config_file.endswith('.env'):
                self.load_env_variables()
                logging.info(f"Environment variables loaded from {config_file}.")
            else:
                logging.error("Unsupported config file format. Use .yaml, .yml, .json, or .env.")
                raise ValueError("Unsupported config file format. Use .yaml, .yml, .json, or .env.")
            
            self.validate_config()
        except Exception as e:
            logging.error(f"Failed to load configuration: {e}")
            raise

    def load_schema(self, schema_file):
        """Load JSON schema for configuration validation."""
        try:
            with open(schema_file, 'r') as file:
                self.schema = json.load(file)
                logging.info(f"Schema loaded from {schema_file}.")
        except Exception as e:
            logging.error(f"Failed to load schema: {e}")
            raise

    def validate_config(self):
        """Validate the loaded configuration against the schema."""
        if self.schema:
            try:
                validate(instance=self.config, schema=self.schema)
                logging.info("Configuration validated successfully.")
            except ValidationError as e:
                logging.error(f"Configuration validation error: {e.message}")
                raise

    def get(self, key, default=None):
        """
        Get a configuration value by key.

        :param key: The key of the configuration setting.
        :param default: The default value to return if the key is not found.
        :return: The configuration value or the default value.
        """
        return self.config.get(key, os.getenv(key, default))

    def set(self, key, value):
        """
        Set a configuration value.

        :param key: The key of the configuration setting.
        :param value: The value to set.
        """
        self.config[key] = value
        logging.info(f"Configuration set: {key} = {value}")

    def reload(self, config_file):
        """Reload the configuration from the specified file."""
        logging.info("Reloading configuration...")
        self.load_config_file(config_file)

# Example usage
if __name__ == "__main__":
    config_manager = ConfigManager(config_file='config/application.yml', schema_file='config/schema.json')
    db_host = config_manager.get('DATABASE_HOST', 'localhost')
    print(f"Database Host: {db_host}")

    # Reload configuration if needed
    # config_manager.reload('config/application.yml')

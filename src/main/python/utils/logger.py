import logging
import os
import time
from contextlib import contextmanager

class Logger:
    def __init__(self, name: str, log_file: str = 'app.log'):
        self.logger = logging.getLogger(name)
        self.logger.setLevel(logging.DEBUG)
        formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')

        # Console handler
        ch = logging.StreamHandler()
        ch.setFormatter(formatter)
        self.logger.addHandler(ch)

        # File handler
        if not os.path.exists(log_file):
            open(log_file, 'w').close()  # Create the log file if it doesn't exist
        fh = logging.FileHandler(log_file)
        fh.setFormatter(formatter)
        self.logger.addHandler(fh)

    def debug(self, message: str):
        self.logger.debug(message)

    def info(self, message: str):
        self.logger.info(message)

    def warning(self, message: str):
        self.logger.warning(message)

    def error(self, message: str):
        self.logger.error(message)

    def critical(self, message: str):
        self.logger.critical(message)

    @contextmanager
    def log_execution_time(self, task_name: str):
        start_time = time.time()
        yield
        end_time = time.time()
        self.info(f"Execution time for {task_name}: {end_time - start_time:.2f} seconds")

# Example usage
# logger = Logger(__name__)
# with logger.log_execution_time("Data Loading"):
#     # Simulate data loading
#     time.sleep(2)

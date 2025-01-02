#!/bin/bash

set -e  # Exit immediately if a command exits with a non-zero status

# Function to run Java tests
run_java_tests() {
    echo "Running Java tests..."
    ./gradlew test --info --stacktrace
}

# Function to run Python tests
run_python_tests() {
    echo "Running Python tests..."
    python3 -m unittest discover -s tests/python -v
}

# Function to generate test coverage report
generate_coverage_report() {
    echo "Generating coverage report..."
    # For Java
    ./gradlew jacocoTestReport
    # For Python
    coverage run -m unittest discover -s tests/python
    coverage report
}

# Main script execution
run_java_tests
run_python_tests
generate_coverage_report

echo "All tests completed successfully!"

#!/bin/bash

set -e  # Exit immediately if a command exits with a non-zero status

# Function to generate Java documentation
generate_java_docs() {
    echo "Generating Java documentation..."
    ./gradlew javadoc
    echo "Java documentation generated at build/docs/javadoc."
}

# Function to generate Python documentation
generate_python_docs() {
    echo "Generating Python documentation..."
    cd docs/
    sphinx-build -b html . _build/html
    echo "Python documentation generated at docs/_build/html."
    cd ..
}

# Function to publish documentation (e.g., to GitHub Pages)
publish_docs() {
    echo "Publishing documentation..."
    # Example for GitHub Pages
    git checkout gh-pages
    cp -r docs/_build/html/* .
    git add .
    git commit -m "Update documentation"
    git push origin gh-pages
    git checkout main
}

# Main script execution
generate_java_docs
generate_python_docs
publish_docs

echo "Documentation generation and publishing completed successfully!"

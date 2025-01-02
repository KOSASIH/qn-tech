#!/bin/bash

# deploy.sh
set -e  # Exit immediately if a command exits with a non-zero status

# Load environment variables
source ./config/secrets.env

# Define variables
APP_NAME="qn-tech"
BUILD_DIR="build"
DEPLOY_DIR="/var/www/$APP_NAME"
GIT_BRANCH=$(git rev-parse --abbrev-ref HEAD)

# Logging function
log() {
    echo "$(date +'%Y-%m-%d %H:%M:%S') - $1"
}

log "Starting deployment for branch: $GIT_BRANCH"

# Build the application
log "Building the application..."
./gradlew build || { log "Build failed!"; exit 1; }

# Run tests
log "Running tests..."
./run_tests.sh || { log "Tests failed!"; exit 1; }

# Deploy to server
log "Deploying to $DEPLOY_DIR..."
rsync -avz --delete $BUILD_DIR/ $DEPLOY_DIR/ || { log "Deployment failed!"; exit 1; }

log "Deployment completed successfully!"

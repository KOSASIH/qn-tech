#!/bin/bash

# setup_environment.sh
set -e  # Exit immediately if a command exits with a non-zero status

# Define variables
PYTHON_VERSION="3.9"
NODE_VERSION="14"
JAVA_VERSION="11"

# Logging function
log() {
    echo "$(date +'%Y-%m-%d %H:%M:%S') - $1"
}

log "Setting up the environment..."

# Update package list
log "Updating package list..."
sudo apt-get update

# Install Python
log "Installing Python $PYTHON_VERSION..."
sudo apt-get install -y python$PYTHON_VERSION python3-pip

# Install Node.js
log "Installing Node.js $NODE_VERSION..."
curl -sL https://deb.nodesource.com/setup_$NODE_VERSION.x.x | sudo -E bash -
sudo apt-get install -y nodejs

# Install Java
log "Installing Java $JAVA_VERSION..."
sudo apt-get install -y openjdk-$JAVA_VERSION-jdk

# Install Python dependencies
log "Installing Python dependencies..."
pip3 install -r requirements.txt

# Install Node.js dependencies
log "Installing Node.js dependencies..."
npm install

log "Environment setup completed successfully!"

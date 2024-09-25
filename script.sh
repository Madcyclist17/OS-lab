#!/bin/bash

echo "Starting script..."
read -p "Enter your name: " name
echo "Hello, $name!"

echo "Current directory is: $(pwd)"
echo "Listing files:"
ls -l

echo "Script finished."


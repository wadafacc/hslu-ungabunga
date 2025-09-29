#!/bin/bash

echo "🔍 Running lint checks with flake8..."
flake8 .

echo "🎨 Checking code formatting with black..."
black . --check

echo "🧪 Running tests with pytest..."
pytest --cov=src tests/

echo "✅ All checks passed successfully!"
import requests
from src.core.search import search

# test if search returns results
def test_search_basic():
    results = search("potato")
    assert isinstance(results, list)

# API Test: Tests the route on functionality
def test_search_endpoint_returns_results():
    response = requests.get("http://api:8000/search", params={"q": "potato"})
    
    assert response.status_code == 200
    data = response.json()

    assert isinstance(data, list), "Expected response to be a list"
    assert len(data) > 0, "Expected at least one result"
    assert all("title" in item for item in data), "Each item should contain a 'title'"

from fastapi import FastAPI
from dotenv import load_dotenv
import sys
from src.core.search import search

import os
load_dotenv()

MAX_RESULTS = os.getenv('MAX_RESULTS') or 25

app = FastAPI()

@app.get("/q")
def query(query: str):
  return search(query)[:MAX_RESULTS]
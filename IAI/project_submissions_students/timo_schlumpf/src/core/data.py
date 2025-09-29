import json
from dotenv import load_dotenv

load_dotenv()

def load_keywords():
  with open('data/keywords.txt') as f:
    return f.read().splitlines()
  print("> keywords loaded")

def load_inv_idx():
  with open('data/out_inverted_idx.json', encoding='utf-8') as f:
    data = json.load(f)
    return data
  print("> inverted index loaded")

def load_sitedata():
  with open('data/out_v1.json', encoding='utf-8') as f:
    data = json.load(f)
    return data
  print("> sitedata loaded")

def get_sitedata(url: str) -> object:
  for elem in SITEDATA:
    if elem['url'] == url:
      return elem

###############################################################################
# "Global" Variables
###############################################################################
KEYWORDS = load_keywords()
INV_IDX = load_inv_idx()
SITEDATA = load_sitedata()
LOADED = False

if __name__ == '__main__':
  if KEYWORDS and INV_IDX and SITEDATA:
    LOADED = True
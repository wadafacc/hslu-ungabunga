from src.core.data import INV_IDX, SITEDATA, KEYWORDS, LOADED, get_sitedata  # import relevant data
from collections import Counter
from dotenv import load_dotenv
import os

load_dotenv()
MAX_RESULTS = os.getenv('MAX_RESULTS') or 25

# checks if the page contains the word(s) in body
def scan_page(query:list, url: str) -> bool:
  page = get_sitedata(url)['content_text']

  if any(q in page for q in query):
    return True
  return False

# looks up inverted index with query
def lookup(keyword: str) -> list:
  # cant lookup anything if it's not in KEYWORDS; keyword will be used in page scan afterwards
  if not [v for v in KEYWORDS if keyword in v]:
    return 'NOT FOUND'
  
  for item in INV_IDX:
    if keyword in item['keyword']:
      return item['matches']


# returns a list of possible search results
def search(query: str) -> list:
  results = []
  # only process requests if data has finished loading

  query = query.lower().split(" ") # get individual words

  # get matches for all keywords used, and put words that are not a keyword into the flagged array to check later
  all_links = []
  flagged_keywords = []
  for word in query:
    res = lookup(word)
    if res != 'NOT FOUND':
      all_links.extend(res)
    else:
      flagged_keywords.append(word)

  #get all matching / shared urls between keywords (which, logically, should be the best ones)
  cnt = Counter(all_links)
  shared = [k for k, v in cnt.items() if v > len(query) -1]

  # edgecase: if no urls at all have been found, just look through all of them
  if len(shared) == 0:
    all_links = [item['url'] for item in SITEDATA]

  if len(shared) < MAX_RESULTS:
    for link in all_links:
      if scan_page(flagged_keywords, link):
        shared.append(link)

  for url in shared:
    data = get_sitedata(url)
    data['content_text'] = data['content_text'][:256] 
    results.append(data)
  return results
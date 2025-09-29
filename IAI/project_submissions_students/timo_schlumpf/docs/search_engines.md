# How do Search Engines work?
## TL;DR
0. Gather LOADS of data & invert-index it
   - `id=1: Cat` => `word=Cat: id 1`
1. Parse Search query: turn your gibberish into readable text
   - `How do know if ptasta is god` => `how do i know if my pasta is done`
2. Index & Search for matching data in the Database
   - if no direct match can be found via inverted indexes:
     - Read through page contents line for line and look for matches (`page.contains(query)`)
3. Filter, pretty-fy & prepare result
4. Voilà!

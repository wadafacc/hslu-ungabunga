import streamlit as st
import requests

from dotenv import load_dotenv
load_dotenv()

with st.chat_message("assistant"):
  st.text("""
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣠⣤⠶⠛⠛⠛⠛⠛⠛⠛⠛⠛⠲⠶⠦⣤⣤⣀⣠⣤⣄⡀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡴⠶⠚⠋⠉⠉⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠛⠶⢿⣦⡀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⠟⠉⠀⠀⠀⠀⠀⠀⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀ ⠀⠀⠀⠀⠙⢦⡀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢀⣠⡴⠞⠛⢹⡌⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⡤⣄⠀⢻⡄⠀
⠀⠀⠀⠀⠀⣀⡴⠟⠉⠀⠀⠀⠸⡅⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠀⠀⢿⡄
⠀⠀⠀⢠⡾⠋⠀⠀⠀⠀⠀⠀⠀⠙⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠷⢦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡀⠀⠀⣧
⠀⠀⣰⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠦⠼⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠁⠀⠀⢸
⠀⣼⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⢲⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼
⢸⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣦⣴⣇⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠤⣀⠀⠀⢀⠀⠀⠀⠀⠀⠀⣠⡟
⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠘⠋⠀⠀⠀⠀⠀⠀KARTOSHKA™⠀⠀⠀⠀⠀⠈⠉⠉⠙⠳⠤⢤⣤⣤⣾⠟⠀
⣼⡴⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀SEARCH ENGINE⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⠃⠀⠀
⣿⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡎⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠋⠀⠀⠀
⣇⠻⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠀⠀⠀⠀⠀⠀⣠⡾⠟⠁⠀⠀⠀⠀
⢹⡀⠘⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⢦⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⢆⠀⠀⠀⠀⠀⠀⠀⢠⣾⠏⠀⠀⠀⠀⠀⠀⠀
⠀⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠹⣄⠀⠀⠀⠀⠀⠀⠀⠀⠉⠒⠚⠓⠤⢴⣾⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠙⢦⣄⠀⠀⠀⠀⢠⡶⠖⢦⠀⠀⠀⠀⠀⢇⠀⠀⠀⠀⠀⠀⠉⠁⠒⠂⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠈⠛⠶⣤⣀⣀⠙⠛⠋⠀⠀⠀⠀⠀⠀⠙⠓⠶⠦⣄⡀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣶⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⠛⠒⠶⠶⢤⣤⣤⣤⣤⣶⣶⣾⣿⠟⠛⠛⠛⠛⠛⠛⠛⠛⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
""")

query = st.chat_input(placeholder='search kartoshka')

if query:
  with st.chat_message("user"):
    st.write(query)
  try:
    with st.chat_message("assistant"):
      st.write("browsing the kartoska library...")
      st.spinner('pitchforking...', show_time=True)

    response = requests.get(f'http://api:8000/q?query={query}')
    data = response.json()

    for url in data:
      with st.chat_message("assistant"):
        st.page_link(page=url['url'], label=url['title'], use_container_width=True, icon='🥔')
        st.text(url['content_text'])
  except:
    pass

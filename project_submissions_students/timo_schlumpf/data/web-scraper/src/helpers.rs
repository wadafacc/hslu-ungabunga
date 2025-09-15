use std::collections::{BTreeMap, HashMap, HashSet};

use regex::Regex;
use scraper::{Html, Selector};

pub fn get_potato_links(page: Html) -> Vec<String> {
  let a_sel = Selector::parse("a").expect("selector failed");
  
  page.select(&a_sel)
  .map(|frag| frag.value().attr("href").unwrap_or("").to_string())
  .filter(|l| l.contains("http"))
  .collect()
}

pub fn get_ps(page: Html) -> Vec<String> {
  let p_sel = Selector::parse("p").expect("selector failed");

  page.select(&p_sel)
  .map(|el| sanitize_text(el.text().collect()))
  .collect()
}

// replace tabs & more than 1 spaces
fn sanitize_text(txt: String) -> String {
  let reg = Regex::new(r"\s{1,}").unwrap();
  reg.replace_all(&txt.replace("\t", " "), " ").to_string()
}

pub fn get_title(page: Html) -> String {
  let p_sel = Selector::parse("title").expect("selector failed");

  match page.select(&p_sel).nth(0) {
    Some(e) => e.text().collect(),
    None => "".to_string()
  }
}

// fancy way of saying "get most used words in page"
pub fn get_keywords(content: Vec<String>) -> Vec<String> {
  let mut keywords: BTreeMap<String, i32> = BTreeMap::new();

  for v in content.join("").split(" ") {
    *keywords.entry(v.to_string().to_lowercase()).or_insert(1) += 1;
  }

  let sorted: BTreeMap<i32, String> = keywords.into_iter().map(|(k,v)| (v,k)).collect();

  sorted.into_iter().map(|c| c.1).collect()
}
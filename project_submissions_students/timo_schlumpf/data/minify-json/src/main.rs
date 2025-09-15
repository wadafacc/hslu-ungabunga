/*
-> USED FOR GENERATING THE INVERTED INDEX, FOR FASTER QUERY RESULTS!
*/

use std::{fs::{read_to_string, File}, io::Write};

use model::{Index, Site};
use serde_json::to_string;

mod model;

fn main() {
  let binding = read_to_string("../keywords.txt").unwrap();
  let kwds: Vec<&str> = binding.lines().collect();


  let str_in = read_to_string("../out_v1.json").expect("no file");
  let data: Vec<Site> = serde_json::from_str(&str_in).expect("shit");


  let mut out: Vec<Index> = Vec::new();
  for kw in kwds {
    let mut idx = Index {
      keyword: kw.to_string(),
      matches: Vec::new()
    };

    for page in &data {
      if page.content_text.to_lowercase().contains(kw) | page.title.to_lowercase().contains(kw) {
        idx.matches.push(page.url.clone());
      }
    }

    out.push(idx);
  }

  let mut f = File::create_new("../out_inverted_idx.json").expect("shit");
  _ = f.write_all(to_string(&out).unwrap().as_bytes());

}
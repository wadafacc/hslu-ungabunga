use serde::{Serialize, Deserialize};

#[derive(Serialize, Deserialize, Debug, Default, Eq, Hash, PartialEq, Clone)]
pub struct Site {
  pub url: String,
  pub title: String,
  // pub keywords: Vec<String>,
  pub content_text: String
}


#[derive(Serialize, Deserialize, Debug, Default, Eq, Hash, PartialEq, Clone)]
pub struct SiteMinified {
  pub url: String,
  pub title: String,
  pub keywords: Vec<String>
}

#[derive(Serialize, Deserialize, Debug)]
pub struct Index {
  pub keyword: String,
  pub matches: Vec<String>
}
use serde::{Serialize, Deserialize};

#[derive(Serialize, Deserialize, Debug, Default, Eq, Hash, PartialEq, Clone)]
pub struct Site {
  pub url: String,
  pub title: String,
  pub keywords: Vec<String>,
  pub content_text: Vec<String>
}
/*
----- NOTE -----
-> Yes, this scraper is not written in python, for a simple reason: speed!
I've decided to include it in the submission either way, as for completion-cy purposes.
*/
mod helpers;
mod model;

use std::{collections::HashSet, fs::{read_to_string, File}, io::Write, time::Duration};

use futures::future::{join_all, BoxFuture};

use reqwest::{Client, Error};
use scraper::Html;

use helpers::*;
use model::*;
use serde_json::to_string;

#[tokio::main]
async fn main() -> Result<(), Error> {
  let str_in = read_to_string("./seeds.txt").expect("no seeds.txt file.");
  let seeds_list: Vec<String> = str_in.lines().map(|l| l.to_string()).collect();
  let mut db: HashSet<Site> = HashSet::new();

  
  let client = Client::builder()
  .user_agent("POTATO RESEARCH PROJECT @ [HSLU]")
  .timeout(Duration::from_secs(60))
  .build()?;

  let mut fts: Vec<BoxFuture<'_, (Site, Vec<String>)>> = Vec::new();

  for seed_url in seeds_list {
    let client_clone = client.clone();

    let future = Box::pin(async move { fetch(client_clone, seed_url.clone()).await });
    fts.push(future);
  }
  // first level links
  let items = join_all(fts).await;

  // second level links
  let stats = File::create_new("./stats_2nd.txt").expect("shit");
  let res = fetch_children(&mut db, items, client.clone(), stats).await;
  _ = res.into_iter().for_each(|(e, _)| { db.insert(e); });

  let mut file = File::create_new("./out.json").expect("shit");

  _ = file.write_all(to_string(&db).unwrap().as_bytes());

  Ok(())
}


async fn fetch_children(
  db: &mut HashSet<Site>, 
  items: Vec<(Site, Vec<String>)>, 
  client: Client, 
  mut stats: File
) -> Vec<(Site, Vec<String>)> {
  let mut child_fts: Vec<BoxFuture<'_, (Site, Vec<String>)>> = Vec::new();
  for (site, links) in items {
    _ = stats.write_all(format!("{}: {} sub-links\n", site.url, links.len()-1).as_bytes());
    db.insert(site);
    
    for url in links {
      let client_clone = client.clone();
      let ft = Box::pin(async move { fetch(client_clone, url).await });
      child_fts.push(ft);
    }
  }

  join_all(child_fts).await
}

async fn fetch(client: Client, seed_url: String) -> (Site, Vec<String>) {
  let res = match client.get(seed_url).send().await {
    Ok(r) => r,
    Err(e) => {
      println!("{:?}", e);
      return (Site { ..Default::default() }, vec!["".to_string()]);
    },
  };

  let url = res.url().to_string();
  let html = Html::parse_document(&res.text().await.unwrap_or("".to_string()));

  println!("completed url: {}", url.clone());
  let content = get_ps(html.clone());
  let site = Site {
    url,
    keywords: get_keywords(content.clone()),
    title: get_title(html.clone()),
    content_text: content
  };

  return (site, get_potato_links(html));
}
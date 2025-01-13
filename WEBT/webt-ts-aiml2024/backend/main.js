import express from 'express';
import { MongoClient }  from 'mongodb';
const router = express.Router();

const client = new MongoClient('mongodb://localhost:27017');
const db = client.db('WEBT');
const links = db.collection('links');

router.get('/cookie', (req,res) => {
  if (!req.cookies.biscuit) {
    res.cookie('biscuit', randomHex(16));
  }
  res.send();
});

router.post('/store', async (req,response) => {
  // cookie check
  if (!req.cookies.biscuit) {
    return response.status(401).send();
  }

  // parse json & validate body
  let data = JSON.parse(req.body);
  if (!validateBody(data)) {
    return response.status(400).send();
  }

  let slug = generateSlug(req.cookies.biscuit);
  data.slug = slug;

  // catch error directly, if one occurs -> reponse not needed otherwise
  await links.insertOne(data).catch(e => { return response.status(404).send(); });

  // if successful
  let count =  req.cookies.count ? (Number(req.cookies.count) + 1) : 1;
  response.cookie('count', count);
  data.count = count;
  
  return response.json(data).send();
});

export const module = {
  path: '/',
  router: router
};

function randomHex(len) {
  return [...Array(len)].map(() => Math.floor(Math.random() * 16).toString(16)).join('');
}

function generateSlug(id) {
  let rand = Math.floor(Math.random() * id.length);
  let num = Number("0x" + id.slice(rand, rand + 1));
  return randomHex(6).split("").map(l => (Number("0x" + l) + num).toString(16)).join("");
}

function validateBody(data) {
  if (validateDate(data.date) && data.url && data.title) {
    return true;
  }
  return false;
}

// check if it matches the following format: 1111-02-12T11:11
function validateDate(d) {
  if (d.match(/[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}/gm)) {
    return true;
  }
  return false;
}
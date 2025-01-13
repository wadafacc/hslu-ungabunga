import express from 'express';
import { MongoClient }  from 'mongodb';
const router = express.Router();

const client = new MongoClient('mongodb://localhost:27017');
const db = client.db('WEBT');
const links = db.collection('links');


// redirect to the url if it exists
router.get('/:id', async (req, res) => {
  const id = req.params.id;
  if (!id) {
    return res.status(400).send();
  }

  const element = await links.findOne({slug: id});

  if (element) {
    res.redirect(element.url);
  }

  return res.status(404).send();
});

// delete if url exists in db
router.delete('/:id', async (req, res) => {

  // optional: authentication using user token - not done due to keeping the api open -> token is never communicated to the user either

  const id = req.params.id;
  if (!id) {
    return res.status(400).send();
  }

  await links.findOneAndDelete({slug: id}).catch((e) => { return res.status(400).send(); });

  return res.status(204).send();
});

// change the url the slug points to
router.patch('/:id', async (req, res) => {
  const id = req.params.id;
  const newUrl = req.query.url;

  // check that the new url is "valid" -> can't do fetch-check from backend for some reason -> timeout
  if (!id | !newUrl.match(/https?:\/\/.+\..+/gm)) {
    return res.status(400).send();
  }

  await links.findOneAndUpdate({slug: id}, {$set: {url: newUrl}}).catch((e) => { return res.status(400).send(); });
  
  return res.status(204).send();
});


export const module = {
  path: '/api/',
  router: router
};
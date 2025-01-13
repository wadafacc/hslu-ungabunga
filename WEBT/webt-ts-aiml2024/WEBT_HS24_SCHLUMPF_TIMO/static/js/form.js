async function uploadData() {
  event.preventDefault();
  const form = document.getElementById('data-form');

  // rest doesn't need validation since it's already forced by input fields
  if (!await validateUrl(form.elements.url.value)) {
    alert("Please supply a valid URL");
    return;
  }

  const data = {
    url: form.elements.url.value,
    title: form.elements.title.value,
    date: form.elements.date.value
  };

  let res = await fetch('/store', {
    method: 'post',
    credentials: 'include',
    body: JSON.stringify(data)
  }).catch((err) => alert(err));
  res = await res.json();

  displayData(res);
}

function displayData(res) {
  const title = document.getElementById('title');
  const url = document.getElementById('url');
  const date = document.getElementById('date');
  const shortened = document.getElementById('shortened');
  const count = document.getElementById('count');

  // 1212-12-12T11:11
  let [d, t] = res.date.split("T");
  date.innerText = `${d.split("-").reverse().join("/")}, ${t}`;

  title.innerText = res.title;
  url.href = res.url;
  url.innerText = res.url;

  shortened.href = `${location.origin}/api/${res.slug}`;
  shortened.innerText = `${location.origin}/api/${res.slug}`;

  count.innerText = res.count;

  document.getElementById('output').hidden = false;
}

// cheeky validate
async function validateUrl(url) {
  if (!url) {
    url = document.getElementById('input-url').value;
  }

  const res = await fetch(url, {mode:'no-cors'}).catch((err) => { return { status: 404 }});
  if (res.status == 404) {
    toggleErrorMessage();
    return false;
  }
  
  try {
    document.getElementById('error-url').remove();
  }
  catch {
    // nothing to do here
  }
  return true;
}
function toggleErrorMessage() {
  const root = document.getElementById('errors');

  // check if error message is displayed already
  if (document.getElementById('error-url')) {
    return;
  }

  const error = document.createElement('li');
  error.innerText = 'invalid url!';
  error.id = 'error-url';

  root.appendChild(error);
}
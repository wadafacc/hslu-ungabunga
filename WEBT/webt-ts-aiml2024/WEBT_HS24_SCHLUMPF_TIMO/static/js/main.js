async function setCookie() {
  await fetch('/cookie').catch(e => alert(e));
}

function w3_open() {
  document.getElementById("sidebar").style.display = "block";
}

function w3_close() {
  document.getElementById("sidebar").style.display = "none";
}
function swap(id) {
  const item = document.getElementById(id);

  const url = item.dataset.url;
  const currentUrl = item.src;

  item.dataset.url = currentUrl;
  item.src = url;
}
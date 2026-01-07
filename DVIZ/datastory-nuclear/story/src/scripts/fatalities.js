/*
-> Implements a custom svg that allows scrolling to properly visualize the difference.
Purely artisanal, handmade code.
*/

const zoom = document.getElementById('zoom');
const graph = document.getElementById('bubbles-graph');

// load the svg to keep it from rasterizing
document.addEventListener('DOMContentLoaded', async () => {
  await fetch("./src/images/death_rates_energy_prod.svg")
    .then(res => res.text())
    .then(text => graph.innerHTML = text);

  zoomToElement(document.querySelector('#coal-bubble'))
});


/*
-> ZOOM & PANNING FUNCTIONALITY
*/
var
  panning = false,
  scale = 1,
  pointX = 0,
  pointY = 0;
var start = { x: 0, y: 0 };

// panning
zoom.addEventListener('mousedown', (e) => {
  e.preventDefault();
  start = { x: e.clientX - pointX, y: e.clientY - pointY };
  panning = true;
});

zoom.addEventListener('mouseup', (e) => {
  panning = false;
});

// prevents the page from sticking to the mouse when the mouse moves out of the zoom window
zoom.addEventListener('mouseleave', (e) => {
  panning = false;
});

zoom.addEventListener('mousemove', (e) => {
  e.preventDefault();
  if (!panning) {
    return;
  }
  pointX = (e.clientX - start.x);
  pointY = (e.clientY - start.y);
  setTransform();
});

zoom.addEventListener('wheel', (e) => {
  e.preventDefault();
  var xs = (e.clientX - pointX) / scale,
    ys = (e.clientY - pointY) / scale,
    delta = (e.wheelDelta ? e.wheelDelta : -e.deltaY);
  (delta > 0) ? (scale *= 1.1) : (scale /= 1.1);
  pointX = e.clientX - xs * scale;
  pointY = e.clientY - ys * scale;

  setTransform();
});

function setTransform() {
  graph.style.transformOrigin = "0 0";
  graph.style.transform = "translate(" + pointX + "px, " + pointY + "px) scale(" + scale + ")";
}

// ai generated; time crunch
function zoomToElement(el, padding = 40, maxScale = 6) {
  const bbox = el.getBBox(); // SVG coordinates

  const zoomRect = zoom.getBoundingClientRect();

  // scale needed to fit element
  const scaleX = (zoomRect.width - padding * 2) / bbox.width;
  const scaleY = (zoomRect.height - padding * 2) / bbox.height;

  scale = Math.min(scaleX, scaleY, maxScale);

  // center element
  pointX = zoomRect.width / 2 - (bbox.x + bbox.width / 2) * scale;
  pointY = zoomRect.height / 2 - (bbox.y + bbox.height / 2) * scale;

  setTransform();
}

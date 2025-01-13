const canvas = document.getElementById('static-canvas');
if (canvas.getContext) {
  const ctx = canvas.getContext("2d");

  ctx.fillStyle = 'lightblue';
  ctx.fillRect(10, 10, 10, 10);

  ctx.strokeStyle = 'blue';
  ctx.strokeRect(10, 10, 10, 10);

  ctx.fillStyle = 'red';
  ctx.fillRect(148, 10, 10, 10);

  ctx.strokeStyle = 'crimson';
  ctx.strokeRect(148, 10, 10, 10);

  ctx.fillStyle = 'black';
  ctx.font = '24px Crimson Text';
  ctx.fillText('your url', 50, 20);

  ctx.beginPath();
  ctx.moveTo(84, 30);
  ctx.lineTo(84, 40);
  ctx.strokeStyle = 'black';
  ctx.lineWidth = 2;
  ctx.stroke();

  ctx.beginPath();
  ctx.moveTo(74, 40);
  ctx.lineTo(94, 40);
  ctx.lineTo(84, 55);
  ctx.closePath();
  ctx.strokeStyle = 'black';
  ctx.stroke();
  ctx.fillStyle = 'transparent';
  ctx.fill();

  ctx.fillStyle = 'black';
  ctx.font = '24px Crimson Text';
  ctx.fillText('[ shortener ]', 25, 80);

  ctx.beginPath();
  ctx.moveTo(84, 90);
  ctx.lineTo(84, 100);
  ctx.strokeStyle = 'black';
  ctx.lineWidth = 2;
  ctx.stroke();

  ctx.beginPath();
  ctx.moveTo(74, 100);
  ctx.lineTo(94, 100);
  ctx.lineTo(84, 115);
  ctx.closePath();
  ctx.strokeStyle = 'black';
  ctx.stroke();
  ctx.fillStyle = 'transparent';
  ctx.fill();

  ctx.fillStyle = 'black';
  ctx.font = '24px Crimson Text';
  ctx.fillText('/api/<slug>', 25, 140);
}
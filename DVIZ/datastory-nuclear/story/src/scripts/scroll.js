const dot = document.getElementById('scroll-dot');
const bg = document.getElementById('scroll-bg');

document.addEventListener('scroll', (ev) => {
  const scrollTop = window.scrollY;
  const docHeight = document.documentElement.scrollHeight - document.documentElement.clientHeight;
  const scrollPercent = (scrollTop / docHeight) * 100;
  bg.style.height = `calc(20px + ${scrollPercent}%)`;
});

// Scroll animation for sections
const sections = document.querySelectorAll('section');
const observerOptions = {
  threshold: 0.2,
  rootMargin: '0px 0px -150px 0px'
};

const observer = new IntersectionObserver((entries) => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      entry.target.classList.add('visible');
    }
  });
}, observerOptions);

sections.forEach(section => {
  observer.observe(section);
});

// Timeline fade-in on scroll
const historyEvents = document.querySelectorAll('.history-event');

const historyObserver = new IntersectionObserver((entries) => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      entry.target.classList.add('visible');
    }
  });
}, {
  threshold: 0.3,
  rootMargin: '0px 0px -50px 0px'
});

historyEvents.forEach(event => {
  historyObserver.observe(event);
});
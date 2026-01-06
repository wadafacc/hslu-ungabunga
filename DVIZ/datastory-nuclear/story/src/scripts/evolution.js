const reactors = [
  {
    id: "evolution-1942",
    year: 1942,
    name: "Chicago Pile-1 (CP-1)",
    // src: "cp1.webm",
    dangerous: false,
    description: "The first reactor to sustain a nuclear chain reaction. It showed that fission works but wasn’t meant to make electricity and had no safety systems."
  },
  {
    id: "evolution-1957",
    year: 1957,
    name: "Shippingport Pressurized Water Reactor (PWR)",
    // src: "shippingport-pwr.webm",
    dangerous: false,
    description: "A water-cooled reactor that kept water under pressure to make steam for electricity. Safer and controllable compared to early experiments, but still relied on complex systems."
  },
  {
    id: "evolution-1965",
    year: 1965,
    name: "Standardized Pressurized Water Reactor (PWR)",
    // src: "pwr.webm",
    dangerous: false,
    description: "A refined design for large-scale electricity. Standard parts made it more reliable, though high-pressure operation was complex and costly."
  },
  {
    id: "evolution-1970",
    year: 1970,
    name: "Commercial Boiling Water Reactor (BWR)",
    // src: "bwr.webm",
    dangerous: false,
    description: "Water boils directly in the reactor to make steam for turbines. Simpler than PWRs, but radioactive steam needs careful control."
  },
  {
    id: "evolution-1986",
    year: 1986,
    name: "Chernobyl RBMK (High Power Channel-type Reactor, RBMK)",
    // src: "rbmk.webm",
    dangerous: true,
    description: "Used graphite and water to produce high power and could be refueled while running. Lacked a full safety shell, making it unstable and prone to accidents."
  },
  {
    id: "evolution-1994",
    year: 1994,
    name: "Advanced Boiling Water Reactor (ABWR)",
    // src: "abwr.webm",
    dangerous: false,
    description: "A safer, more efficient version of the BWR. Internal pumps and digital controls make it easier to operate, though it still needs active safety systems."
  },
  {
    id: "evolution-2000",
    year: 2000,
    name: "Advanced Passive Pressurized Water Reactor (AP1000)",
    // src: "ap1000.webm",
    dangerous: false,
    description: "Uses gravity and natural flow to stay safe in emergencies. Safer than older reactors, but produces a bit less power."
  },
  {
    id: "evolution-2010s",
    year: 2010,
    name: "Vodo-Vodyanoi Energetichesky Reactor-1200 (VVER-1200)",
    // src: "vver-1200.webm",
    dangerous: false,
    description: "A modern reactor with extra safety layers and backup systems. More accident-tolerant, but expensive and complex to build."
  },
  {
    id: "evolution-2020s",
    year: 2020,
    name: "Small Modular Reactors (SMRs) and Generation IV Concepts",
    // src: "smr-gen4.webm",
    dangerous: false,
    description: "Small, modular reactors with new coolants. Designed to be very safe and scalable, though still experimental and costly."
  },
  {
    id: "evolution-future",
    year: 2050,
    name: "Fusion Reactor",
    // src: "fusion.webm",
    dangerous: false,
    description: "Uses the same process as the sun, fusing light atoms to release energy. Almost no long-lived radioactive waste and very safe, but still experimental and not yet producing commercial electricity."
  }
];


const line = document.getElementById('timeline');

const year = document.getElementById('obj-year');
const title = document.getElementById('obj-title');
const desc = document.getElementById('obj-desc');
const img = document.getElementById('obj-img');

// max & min for spacing
const min = reactors[0].year;
const max = reactors[reactors.length-1].year;
const fac = max / min;

document.getElementById('timeline-min').innerText = min;
document.getElementById('timeline-max').innerText = max;

document.addEventListener('DOMContentLoaded', (e) => {
  reactors.forEach(e => {
    const el = document.createElement('div');
    el.id = e.id;
    el.classList.add('dot');
    if (e.dangerous) {
      el.classList.add('dangerous');
    }

    const offset = Math.abs(((max - e.year) / (max - min)) -1 );
    el.style.left = `${offset * 100}%`;


    el.addEventListener('mouseover', () => {
      year.innerText = e.year;
      title.innerText = e.name;
      desc.innerText = e.description;
      // img.src = `./src/images/reactors/${e.src}`;
    });
    line.appendChild(el);
  });
});
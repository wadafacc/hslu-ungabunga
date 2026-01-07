/*
-> Custom worldmap with hover
*/

document.addEventListener('DOMContentLoaded', async () => {
  const map = document.getElementById('map-container');
  // dynamic svg fetch to retain svg id functionality
  const svgText = await fetch("./src/images/world.svg").then(res => res.text());
  map.innerHTML = svgText;

  const svg = map.querySelector("svg");
  svg.setAttribute("width", "100%");
  svg.setAttribute("height", "100%");
  svg.removeAttribute("mapsvg:geoViewBox"); // optional

  // Optionally, compute bounding box of all paths
  const bbox = svg.getBBox();
  svg.setAttribute("viewBox", `${bbox.x} ${bbox.y} ${bbox.width} ${bbox.height}`);

  const paths = map.querySelectorAll("svg path");
  const tooltip = document.getElementById("tooltip");
  const ttTitle = document.getElementById("tt-title");
  const ttState = document.getElementById("tt-state");
  const ttDate = document.getElementById("tt-date");
  const ttNote = document.getElementById("tt-note");

  console.log(paths)
  for (let i = 0; i < paths.length; i++) {
    const path = paths[i];
    const data = mapData.find(e => e.code == path.id);
    if (!data) continue;

    path.classList.add(data.status)

    path.addEventListener("mouseenter", e => {
      const entry = mapData.find(c => c.code == path.id);
      tooltip.style.opacity = "1";
      ttTitle.innerText = entry.country;
      ttState.innerText = entry.status;
      ttDate.innerText = entry.year;
      ttNote.innerText = entry.note;
    });

    path.addEventListener("mousemove", e => {
      const { clientX, clientY } = e;
      console.log(e)
      tooltip.animate([
        {
          top: `${clientY}px`,
          left: `${clientX}px`,
        }
      ], { duration: 250, fill: "forwards" });
    });

    path.addEventListener('mouseleave', () => {
      tooltip.style.opacity = '0';
    });
  }


});


// MAP DATA
const mapData = [
  // --- Phase-out (decided / completed) ---
  {
    code: "DE",
    country: "Germany",
    status: "phase-out",
    year: 2023,
    note: "Post-Fukushima political decision"
  },
  {
    code: "BE",
    country: "Belgium",
    status: "phase-out",
    year: 2025,
    note: "Gradual shutdown, partial extensions debated"
  },
  {
    code: "CH",
    country: "Switzerland",
    status: "phase-out",
    year: null,
    note: "No new builds, lifetime operation only"
  },
  {
    code: "ES",
    country: "Spain",
    status: "phase-out",
    year: 2035,
    note: "Planned decommissioning schedule"
  },
  {
    code: "TW",
    country: "Taiwan",
    status: "phase-out",
    year: 2025,
    note: "Energy transition policy"
  },

  // --- Freeze / no new builds ---
  {
    code: "SE",
    country: "Sweden",
    status: "freeze",
    year: null,
    note: "Long freeze period, recent policy shifts"
  },
  {
    code: "NL",
    country: "Netherlands",
    status: "freeze",
    year: null,
    note: "Historically frozen, new plans debated"
  },

  // --- Expanding / recommitting ---
  {
    code: "FR",
    country: "France",
    status: "expanding",
    year: 2022,
    note: "New EPR program announced"
  },
  {
    code: "GB",
    country: "United Kingdom",
    status: "expanding",
    year: 2020,
    note: "New builds and SMR program"
  },
  {
    code: "CN",
    country: "China",
    status: "expanding",
    year: null,
    note: "Large-scale reactor expansion"
  },
  {
    code: "IN",
    country: "India",
    status: "expanding",
    year: null,
    note: "Domestic reactor program"
  },
  {
    code: "RU",
    country: "Russia",
    status: "expanding",
    year: null,
    note: "Domestic and export reactor builds"
  },
  {
    code: "KR",
    country: "South Korea",
    status: "expanding",
    year: 2022,
    note: "Phase-out reversed"
  },
  {
    code: "JP",
    country: "Japan",
    status: "restarting",
    year: 2022,
    note: "Gradual restarts post-Fukushima"
  },

  // --- Never adopted / marginal ---
  {
    code: "AT",
    country: "Austria",
    status: "never-adopted",
    year: null,
    note: "Nuclear banned by law"
  },
  {
    code: "DK",
    country: "Denmark",
    status: "never-adopted",
    year: null,
    note: "Political prohibition"
  }
];
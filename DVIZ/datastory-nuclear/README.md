# nuclear - a datastory by timo schlumpf


# TLDR;
If you don't want to bother with setting it up locally, go to [wadafacc.github.io](https://wadafacc.github.io/hslu-ungabunga) to see the live web version. it's the exact same version as the one i submitted. 

## Prerequisites
- Download everything
- Cup of Coffee & Snacks
- A good mood :)

## How to run it
Use a local development environment such as the "Life Server" (id: ritwickdey.LiveServer) plugin for VS Code, click go live and open the html file from there. This is necessary as some contents (svgs) are loaded dynamically (fetch api) and will result in a CORS error if not used on a dev server. Otherwise, consider the hosted version on github.io!

# What is where? 
## /diagrams
Contains all source code for the (pre-generated) visuals. This includes all obvious charts.
## /diagrams/data
Contains all datasets used in csv Format. Note: Not all datasets were used to produce a chart, some were used in union with research to produce graphs like [this one](./story/src/images/death_rates_energy_prod.svg).
## /story
contains all files used in the website. Images, scripts, stylings, etc.

## /report
Contains all report files.
## Work Summary
Directly integrated into the report at the end!
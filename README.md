# Boccarusso.com Backend V3

This repo contains the code for the third version of the backend of my personal website.

## Why

The first version was done using PHP and through a heavy use of SSR it was very slow.The second version rebuilds everything from scratch and is made of a frontend made in vanilla JavasScript that through the `controller.js` and `api.js` files mimics the a CSR behavior and of a backend wrote in Spring Boot that simply connects to the database to retrieve the data.
The second version was done in my beginnings and the poor documentation along the poor practices made it quickly something not so feasible to maintain thus quickly becoming legacy code.

This new version uses a frontend done in Angular (work in progress) and a backend wrote back from scratch in Spring Boot.

## How

In the past writing a new post or modifying anything was a hassle possible only by interacting directly with the database. This new version uses Swagger to provide an UI and the actual post content is no more a text stored in the database but a link to the file stored inside a public github repo.

Now the backend is an actaul REST API that permits more flexibility to the maintainance of the content. Every API request, with exceptions to GET ones, are protected by username and password so that only the admin can modify any sensitive data.

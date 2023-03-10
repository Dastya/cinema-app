# 🎥 Cinema-app
<hr>

## 📃 Project description
> Web app that follows RESTful API rules and supports 
> * user authentication / authorization
> * CRUD operations
> 
> Created using Spring & Hibernate

## 🖥 Current project functionality:
<hr>
This is a scheme of cinema app:
<img src="Cinema_scheme.png">

### And here is the list of all endpoints: 
> * POST: /register (all) - new user registration;
> * POST: /cinema-halls (admin) - create a new cinema hall;
> * POST: /movies (admin) - create a new movie;
> * POST: /movie-sessions (admin) - create a new movie session;
> * POST: /orders/complete (user) - create a new order for current user;
> * GET: /cinema-halls (user/admin) - get a list of all cinema halls;
> * GET: /movies (user/admin) - get a list of all movies;
> * GET: /movie-sessions/available (user/admin) - get available movie sessions for specific movie and date;
> * GET: /orders (user) - get a list of orders for current user;
> * GET: /shopping-carts/by-user (user) - get shopping cart of current user;
> * GET: /users/by-email (admin) - get user by email;
> * PUT: /movie-sessions/{id} (admin/root) - update movie session;
> * PUT: /shopping-carts/movie-sessions (user) - creates a ticket and adds it to the shopping cart of current user;
> * DELETE: /movie-sessions/{id} (admin/root) - delete movie session.

<hr>

## 💡 Technologies used
> Java 17, Spring Web MVC, Spring Security, Hibernate, MySql, Tomcat. Maven
 <hr>

## 🔌 How to run my app on your PC: 
> 1. Replace DRIVER, URL, USERNAME, PASSWORD in db.properties on your own;
> 2. Configure tomcat(9.0.50 version required;
> 3. RUN maven package command in terminal;
> 4. Click run button or Shift + f10;
> 5. Congrats, now you can test this app.

📘 WorkshopMongo API

This is a Spring Boot and MongoDB based RESTful API that allows managing users and posts. The application exposes endpoints for basic CRUD operations on users and advanced searches on posts.

# 🔧 Technologies Used

    Java 21+

    Spring Boot

    Spring Data MongoDB

    Dokcer

    MongoDB

    Maven

# 📁 API Endpoints

## 🔹 /users

GET /users

Returns a list of all registered users.

Sample response:
```json
[
  {
    "id": "1",
    "name": "Maria Silva",
    "email": "maria@gmail.com"
  }
]
```

**GET /users/{id}**

Returns a specific user by ID.

**GET /users/{id}/posts**

Returns all posts associated with the user identified by the given ID.

**POST /users**

Creates a new user.

Expected body:

```json
{
  "name": "João Pedro",
  "email": "joao@gmail.com"
}
```

**PUT /users/{id}**

Updates the details of an existing user.

Expected body:

```json
{
  "name": "João Pedro Silva",
  "email": "joaopedro@gmail.com"
}
```
**DELETE /users/{id}**

Deletes a user by ID.

## 🔹 /posts

**GET /posts/{id}**

Returns a specific post by ID.

**GET /posts/titlesearch?text={text}**

Searches for posts that contain the specified text in their title (case-insensitive and partial match).

**GET /posts/fullsearch?text={text}&start={startDate}&end={endDate}**

Performs an advanced search for posts that contain the specified text and fall within a given date range.

Example request:
```text
GET /posts/fullsearch?text=travel&start=2024-01-01&end=2024-12-31
```

📦 DTOs

    UserDTO: Represents the data transferred for a user.

    PostDTO: Represents the data transferred for a post.




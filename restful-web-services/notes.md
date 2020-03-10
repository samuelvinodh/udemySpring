#Restful Web Services

Social Media Application

User -> Posts

- Retrieve all users    - GET /users
- Create a user         - POST /users
- Retrieve a user       - GET /users/{id} -> /users/1
- Delete a user         - DELETE /users/{id} -> /users/1

- Retrieve posts for a user     - GET /users/{id}/posts
- Create posts for a user       - POST /users/{id}/posts
- Retrieve details of a post    - GET /users/{id}/posts/{posts_id}
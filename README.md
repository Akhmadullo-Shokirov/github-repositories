# GitHub Repositories API

This is a Spring Boot application that provides an API to fetch all non-forked repositories of a given GitHub user along with branch details, including the branch name and the last commit SHA.

## Features

- **List Repositories**: Fetch all non-forked repositories for a given GitHub user.
- **List Branches**: For each repository, retrieve all branches with their last commit SHA.
- **Error Handling**: Returns a `404` error if the GitHub user does not exist.

## Technologies Used

- **Java 21**
- **Spring Boot 3**
- **WebClient** for making non-blocking HTTP requests
- **Postman** (for testing)

## Getting Started

### Prerequisites

- Java 21
- Maven 3.6+
- (Optional) Postman for testing the API

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/github-repositories.git
   cd github-repositories

   
2. **Build the project**:
   ```bash
   mvn clean install

3. **Run the application**:
   ```bash
   mvn spring-boot:run
The application will start on `http://localhost:8080`.

## Usage

### API Endpoint

- **Get User Repositories**: Fetch all non-forked repositories of a GitHub user along with branch details.

  **Request**:

  - **Method**: `GET`
  - **URL**: `/users/{username}/repos`
  - **Headers**: 
    - `Accept: application/json`

  **Example**:

  ```bash
    GET http://localhost:8080/users/octocat/repos
    Accept: application/json

### Response

When the request is successful, the API will return a JSON array containing the repositories and their branch details.

**Example Response**:

```json
[
  {
    "name": "Hello-World",
    "owner": {
      "login": "octocat"
    },
    "branches": [
      {
        "name": "main",
        "commit": {
          "sha": "e1e32a9a3f3c3d5f4c3f7e2b3c2f3e4e3a3d2f4c"
        }
      }
    ]
  }
]
```

### Error Response

If the GitHub user does not exist, the API will return a `404` status code with a JSON response.

**Example Error Response**:

```json
{
  "status": 404,
  "message": "User not found"
}
```

### Testing with Postman

To test the API using Postman:

1. **Open Postman**.
2. Click on **"New"** and select **"HTTP Request"**.
3. Set the request type to `GET`.
4. Enter the request URL as `http://localhost:8080/users/{username}/repos` (replace `{username}` with the actual GitHub username).
5. Under the **"Headers"** tab, add the following header:
   - **Key**: `Accept`
   - **Value**: `application/json`
6. Click **"Send"** to execute the request.
7. Inspect the response returned by the API in the lower pane of Postman.

**Example Request in Postman**:

- **URL**: `http://localhost:8080/users/octocat/repos`
- **Method**: `GET`
- **Headers**: 
  - `Accept: application/json`

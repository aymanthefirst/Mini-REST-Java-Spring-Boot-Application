# Customer API Application

## Overview
This Java application imports customer data from a CSV file into a SQL database and provides a REST API to interact with this data. The data loading occurs automatically during the application's startup.

## Prerequisites
- Java JDK 17 or later
- Maven (for building the application)
- PostgreSQL (or any SQL database compatible with Spring Boot)

## Setting Up the Database
1. Install and set up a PostgreSQL server.
2. Create a new database for the application.
3. Update the `application.properties` file under `src/main/resources` with your database connection details:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

## Building and Running the Application
1. Open a terminal or command prompt.
2. Navigate to the root directory of the project.
3. Run the following command to build and start the application:
   ```
   mvn clean install
   ```
   This command compiles the application, runs tests, and starts the application. During the startup, the application loads data from the CSV file into the database.
4. The REST API server will start and run on `http://localhost:8080`.

## Interacting with the REST API
- Use tools like `curl` or Postman to interact with the REST API.
- Available endpoints:
    - GET `/api/customers/{customerRef}`: Retrieve a customer by their reference.
    - POST `/api/customers`: Add a new customer.

## Running Tests
- Run the unit and integration tests using the following Maven command:
  ```
  mvn test
  ```

---

Remember to replace placeholders such as `your_database`, `your_username`, `your_password`, and file paths with actual values. The behavior of data loading at startup should be clearly communicated to users, so they understand that the database will be populated automatically when the application starts.
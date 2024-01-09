Development of a Console Application for CSV Processing

### Initial Set up
The project commenced with establishing the necessary Spring Boot setup, including dependencies for Web, JPA, and PostgreSQL.
I then reorganized the task to start with those that had the higher complexity. A TDD approach was applied.

### Initial test
I started by writing failing end-to-end tests to define what I want the end result to be, which is the data in csv format being loaded into the database, and the ability to GET a user back from the database. 

### Saving Data to Database
Test Cases: Developed test to ensure we are successfully connecting to the database - this can save debugging issues later. 
Implementation: Configured a PostgreSQL database and set up CustomerRepository for data operations. CustomerService was then created to manage business logic and database interactions.

### Sending Data to REST API
Implementation: Implemented customerController to convert Customer objects to JSON and send them to the specified REST API endpoint.
Test Cases: If I had more time I would have written unit tests to ensure that the data is being sent to the REST API correctly, however for now the end-to-end tests suffice as they would also fail if the data was not sent correctly. 

### Reading and Parsing CSV Files
Test Cases: Wrote unit tests for parsing CSV files to ensure that the file is read correctly and the contents are mapped to Java objects.
Implementation: Created a CsvReader utility that handles reading from the CSV and parsing the data.

### Creating a REST API GET Endpoint
Test Cases: This was also covered as part of the initial integration test, so I did not make a unit test for now. However, I would if a second itteration was to be done. 
Implementation: Developed a GET endpoint in CustomerController that takes a customer reference as a parameter and returns the corresponding customer data in JSON format.

### Final manual testing
I manually tested the application by running it and sending requests to the REST API endpoints using Postman. I also checked the database to ensure that the data was loaded correctly.

### Improvements
If there were to be a second iteration of this project, I would have liked to have done the following:
- Write more unit tests to ensure that the data is being sent to the REST API correctly
- Write negative tests to ensure that the application handles errors correctly. e.g. if the CSV file is incorrectly formatted.
- Add more logging to the application to make it easier to debug issues.
- Add more validation to the application to ensure that the data is correct before it is saved to the database.
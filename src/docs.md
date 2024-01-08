Development of a Console Application for CSV Processing

Initial Set up
The project commenced with establishing the necessary Spring Boot setup, including dependencies for Web, JPA, and PostgreSQL.
I then reorganized the task to start with those that had the higher complexity. A TDD approach was applied.

Initial test
I started by writing a failing end-to-end test which defines what I want the end result to be, which is the data in csv format being loaded into the database.
Then another test to make sure that the GET endpoint returns the correct data.

Saving Data to Database
Test Cases: Developed test to ensure we are successfully connecting to the database.
Implementation: Configured a PostgreSQL database and set up CustomerRepository for data operations. CustomerService was then created to manage business logic and database interactions.

Sending Data to REST API
Implementation: Implemented RestApiClient to convert Customer objects to JSON and send them to the specified REST API endpoint.
Test Cases: If I had more time I would have written unit tests to ensure that the data is being sent to the REST API correctly.

Reading and Parsing CSV Files
Test Cases: Wrote unit tests for parsing CSV files to ensure that the file is read correctly and the contents are mapped to Java objects.
Implementation: Created a CsvReader utility that handles reading from the CSV and parsing the data.

Creating a REST API GET Endpoint
Test Cases: Due to lack of time I did not write unit tests for this feature. However, I did manually check in postman to ensure that the endpoint was working correctly. and the feature is already being test by the end-to-end test.
Implementation: Developed a GET endpoint in CustomerController that takes a customer reference as a parameter and returns the corresponding customer data in JSON format.

I also did a quick manual check at the end to ensure that the data was being saved to the database correctly.

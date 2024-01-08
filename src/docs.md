Development of a Console Application for CSV Processing

Initial Setup
The project commenced with establishing the necessary Spring Boot setup, including dependencies for Web, JPA, and PostgreSQL.
I then reorganized the task to start with those that had the higher complexity. A TDD approach was applied.

Saving Data to Database
Test Cases: Wrote tests for saving data to the database using JPA repositories.
Implementation: Configured a PostgreSQL database and set up CustomerRepository for data operations. CustomerService was then created to manage business logic and database interactions.
I also did a quick manual check at the end of this phase to ensure that the data was being saved to the database correctly.

Sending Data to REST API
Test Cases: Developed tests for sending JSON data to a REST API endpoint.
Implementation: Implemented RestApiClient to convert Customer objects to JSON and send them to the specified REST API endpoint.

Reading and Parsing CSV Files
Test Cases: Wrote unit tests for parsing CSV files to ensure that the file is read correctly and the contents are mapped to Java objects.
Implementation: Created a CsvReader utility that handles reading from the CSV and parsing the data. It matched the structure of the CSV file including fields like Customer Ref, Name, Address, etc.

 
Creating a REST API GET Endpoint
Test Cases: Prepared tests to ensure the GET endpoint correctly retrieves customer data based on a unique reference.
Implementation: Developed a GET endpoint in CustomerController that takes a customer reference as a parameter and returns the corresponding customer data in JSON format.

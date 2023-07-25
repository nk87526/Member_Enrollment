

# Member Enrollment REST API

This project implements a RESTful API for member enrollment, allowing clients to create new member enrollments by providing basic member information. The project uses Java and a local H2 Database for data storage.

## Prerequisites

Before running the project, make sure you have the following prerequisites installed:

- Java JDK
- Apache Maven

## Installation

1. Clone the repository:
   ```
   git clone <repository_url>
   ```

2. Build the project with Maven:
   ```
   mvn clean install
   ```

3. Database Configuration:
   - Database URL: jdbc:h2:mem:testdb
   - Username: sa
   - Password: (leave blank)

## Running the Application

To run the application, use the following command:
```
java -jar target/member-enrollment-api.jar
```

## REST API Endpoints

### Create Member Enrollment

- Endpoint: POST /members
- Description: Create a new member enrollment.
- Sample Request:
  ```
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "birthdate": "1990-01-01"
  }
  ```
- Sample Response:
  ```
  "Member enrollment successful!"
  ```

## Unit Testing

To run the unit tests, use the following command:
```
mvn test
```

## Example Usage

To create a new member enrollment, send a POST request to the `/members` endpoint with the required member information in the request body.

Using cURL:
```
curl -X POST -H "Content-Type: application/json" -d '{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "birthdate": "1990-01-01"
}' http://localhost:8080/members
```

Using Postman:
- Method: POST
- URL: http://localhost:8080/members
- Headers: Content-Type: application/json
- Body: Raw (JSON)
  ```
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "birthdate": "1990-01-01"
  }
  ```

## Assumptions and Additional Details

- The birthdate is expected in the format "yyyy-MM-dd."
- Additional fields (if any) in the `Member` entity are of type String for simplicity.

## Known Issues

- (If any known issues exist, mention them here.)

## License

(Optional) Specify the license for your project.
```

If you have any more questions or need further assistance, feel free to ask. Good luck with your assignment!

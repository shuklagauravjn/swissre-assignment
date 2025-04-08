# Service A

Service A is a Spring Boot application that provides an API for managing orders. This application includes a POST endpoint for creating new orders.

## Features

- Create new orders via a POST request to the `/orders` endpoint.
- Order model includes properties such as `id`, `productName`, `quantity`, and `price`.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Building the Application

To build the application, navigate to the project directory and run:

```
mvn clean install
```

### Running the Application

To run the application, use the following command:

```
mvn spring-boot:run
```

The application will start on the default port 8080.

### API Endpoints

- **POST /orders**: Create a new order. The request body should contain a JSON representation of the order.

### Example Request

```json
{
  "productName": "Sample Product",
  "quantity": 2,
  "price": 19.99
}
```

### License

This project is licensed under the MIT License.
# Spring Boot Notifications

This is a simple Spring Boot application that provides a REST API for handling notifications. The application includes a POST endpoint to send notifications.

## Project Structure

```
spring-boot-notifications
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── notifications
│   │   │               ├── NotificationsApplication.java
│   │   │               ├── controller
│   │   │               │   └── NotificationController.java
│   │   │               └── model
│   │   │                   └── Notification.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   └── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── notifications
│       │               └── controller
│       │                   └── NotificationControllerTest.java
│       └── resources
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd spring-boot-notifications
   ```

2. **Build the project:**
   ```
   mvn clean install
   ```

3. **Run the application:**
   ```
   mvn spring-boot:run
   ```

4. **Access the API:**
   The application exposes a POST endpoint at `/notify`. You can send a JSON payload representing a notification to this endpoint.

## Usage

To send a notification, make a POST request to the `/notify` endpoint with the following JSON structure:

```json
{
  "id": "1",
  "message": "Your notification message",
  "timestamp": "2023-10-01T12:00:00Z"
}
```

## Testing

JUnit tests are included in the project to verify the functionality of the NotificationController. You can run the tests using:

```
mvn test
```

## Dependencies

This project uses the following dependencies:

- Spring Boot Starter Web
- Spring Boot Starter Test

## License

This project is licensed under the MIT License.
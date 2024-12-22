# APT Microservices Project: House, Device, and Message Management

## Project Overview
This project showcases a microservices architecture focusing on managing houses, devices, and messages. The backend handles core operations, including CRUD functionalities, while a frontend complements the backend by providing an intuitive interface for interacting with the services.

The primary goal is to demonstrate a robust and scalable architecture using modern development practices and tools.

---

## Microservices Architecture

### Services
1. **House Service**: Manages house-related data, such as addresses and house configurations.
2. **Device Service**: Handles device data and associations with houses.
3. **Message Service**: Facilitates the creation, storage, and retrieval of messages related to devices or houses.

### API Gateway
All services interact through an API Gateway configured with **Spring Cloud Gateway**. The gateway provides a unified entry point for clients, handling authentication and routing.

- **Port**: 8083
- **Security**: GCP OAuth2 for user authentication, with JWT verification for access control.

---

## Schema

![Schema](/md-images/schema.png)

## Technical Stack

### Database Choices
1. **MongoDB**: Used for the `Message Service` due to its performance with data that doesn't change often.
2. **MySQL**: Used for `House` and `Device` services, providing structured data management.

### Deployment
- **Containerization**: Each service is containerized using Docker.
- **Docker Compose**: Used to orchestrate all services into a cohesive application.
- **GitHub Actions**: Automates the build and deployment process for Docker containers, as well as extensive testing of the services.

---

## API Endpoints

### House Service
| Method | Path          | Description                  |
|--------|---------------|------------------------------|
| GET    | /house       | Retrieve all houses.         |

### Device Service
| Method | Path            | Description                     |
|--------|-----------------|---------------------------------|
| GET    | /device        | Retrieve all devices.           |
| POST   | /device        | Add a new device.               |
| PUT    | /device/{id}   | Update a device's details.      |
| DELETE | /device/{id}   | Remove a device.                |

### Message Service
| Method | Path             | Description                    |
|--------|------------------|--------------------------------|
| GET    | /messages        | Retrieve all messages.         |
| POST   | /messages        | Create a new message.          |

---

## Frontend Integration
The frontend provides a user-friendly interface for:
- Viewing houses, viewing and adding devices, and viewing and adding messages.
- Demonstrating the interaction of backend services.
- API calls are fully functional with CORS enabled and tested in a containerized environment.

---

## Testing and Security

### Testing
- **Unit Tests**: Each service includes comprehensive unit tests for all service classes and endpoints.

### Security
- **OAuth2 Authentication**: Implemented at the gateway level.
- **Endpoint Protection**: Secured endpoints require a valid token, while others remain publicly accessible.

---

## Deployment Schema

1. **Docker Containers**: Each service is packaged as a Docker container.
2. **Docker Compose**: Simplifies multi-service deployment.
3. **GitHub Actions**: Automates CI/CD processes, including building and testing services.
![Schema](/md-images/schema.png)


---

## Screenshots and Demonstration
- **Postman Screenshots**: All API endpoints have been tested and verified. Screenshots are available below.
`GET - message:`
![GetMessage](/md-images/message-get.png)
`GET - device:`
![GetDevice](/md-images/device-get.png)
`GET - house:`
![GetHouse](/md-images/house-get.png)
`POST - device:`
![PostDevice](/md-images/device-post.png)
`POST - message:`
![PostMessage](/md-images/message-post.png)
`PUT - device:`
![PutDevice](/md-images/device-put.png)
`DELETE - device:`
![DeleteDevice](/md-images/device-delete.png)
`DELETE - device (without bearer token):`
![NoAuth](/md-images/unauth.png)


- **Demo Video**: A video describing the structure, working, and frontend interaction is available [here](#).

---

## Lessons Learned
This project has deepened my understanding of:
- Microservices architecture and its advantages.
- Effective database management with MongoDB and MySQL.
- Securing APIs using OAuth2 and JWT.
- Implementing CI/CD pipelines with GitHub Actions.
- Designing and testing scalable applications.

---

## Repository
The complete project code is available on GitHub: [AdvancedProgrammingTopics](https://github.com/Xandro-VdV/AdvancedProgrammingTopics) .

---

## Conclusion
This project demonstrates a fully functional microservices-based backend with a connected frontend. The design and implementation fulfill the requirements while showcasing modern software development practices.

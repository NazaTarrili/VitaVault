# 🏥 VitaVault

> Comprehensive Healthcare Information Management System

[![Java](https://img.shields.io/badge/Java-22-orange?logo=java)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![GraphQL](https://img.shields.io/badge/GraphQL-API-e10098?logo=graphql)](https://graphql.org)
[![MySQL](https://img.shields.io/badge/MySQL-Database-blue?logo=mysql)](https://www.mysql.com)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

![VitaVault Banner](./assets/VitaVault_presentation.webp)

**VitaVault** is a comprehensive information management system tailored for healthcare institutions. It provides a unified, efficient solution for medical data management, care coordination, and process optimization — built around a robust **GraphQL API** for flexible and precise data handling.

---

## 🚀 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| Framework | Spring Boot 3 |
| API Layer | GraphQL (Spring for GraphQL) |
| Database | MySQL |
| ORM | Spring Data JPA / Hibernate |
| Utilities | Lombok |
| Build Tool | Maven |

---

## ✨ Key Features

- **Patient & Personal Data Management** — Centralized handling of patient demographics, health records, and coverage plan integration
- **Appointment & Schedule Coordination** — Efficient scheduling with real-time tracking of medical resource availability
- **Hospital Resource Management** — Detailed management of beds, rooms, and facilities with real-time status tracking
- **Clinical Records & Episodes** — Detailed episode tracking, medical notes, and physician directives
- **Billing & Healthcare Coverage** — Streamlined billing and insurance plan management with integrated financial tracking
- **Role-Based Access Control** — Secure user roles to protect data integrity

---

## 📁 Project Structure

```
vitavault/
├── assets/
├── src/
│   └── main/
│       ├── java/com/vitavault/vitavault/
│       │   ├── configuration/       # App & security configuration
│       │   ├── controller/          # GraphQL controllers
│       │   ├── model/               # Domain entities & input objects
│       │   ├── repository/          # Data access repositories
│       │   ├── service/             # Business logic
│       │   └── util/                # Common utilities
│       └── resources/
│           └── graphql/             # GraphQL schema definitions
├── pom.xml
└── README.md
```

---

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- Maven 3.9+
- MySQL 8+

### 1. Clone the repository

```bash
git clone https://github.com/NazaTarrili/VitaVault.git
cd VitaVault
```

### 2. Configure the database

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vitavault
spring.datasource.username=YOUR_DB_USER
spring.datasource.password=YOUR_DB_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run the application

```bash
./mvnw spring-boot:run
```

---

## 🔌 GraphQL API

The GraphQL schema is defined in `src/main/resources/graphql/`. Once the app is running, access the interactive GraphQL playground at:

```
http://localhost:8080/graphiql
```

### Example Query

```graphql
query {
  patients {
    id
    firstName
    lastName
    dateOfBirth
    coveragePlan {
      name
    }
  }
}
```

### Example Mutation

```graphql
mutation {
  createAppointment(input: {
    patientId: "1"
    doctorId: "3"
    dateTime: "2025-06-15T10:30:00"
  }) {
    id
    status
  }
}
```

---

## 🏗️ Use Cases

- **Unified Medical Record Systems** — Centralized storage for patient history and demographics
- **Hospital Resource Management** — Real-time tracking of room and bed occupancy
- **Appointment Scheduling** — Efficient management of provider schedules and patient bookings
- **Integrated Billing Systems** — Simplified management of billing and healthcare coverage

---

## 🤝 Contributors

- [@NazaTarrili](https://github.com/NazaTarrili)

---

## 👨‍💻 Author

**Nazareno Leonel Tarrili Saavedra**

- Portfolio: [nazatarrili.com](https://nazatarrili.com)
- LinkedIn: [linkedin.com/in/nazareno-tarrili](https://www.linkedin.com/in/nazareno-tarrili)
- GitHub: [@NazaTarrili](https://github.com/NazaTarrili)

---

> VitaVault is designed for extensibility, making it suitable for hospitals, clinics, and healthcare institutions aiming for digital transformation and optimized care coordination.

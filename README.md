![Java CI with Maven](https://github.com/pareshmishra23/delta-service/actions/workflows/maven.yml/badge.svg)

# Delta Service

A Spring Boot microservice for reading daily data and persisting it. This also supports dynamic API provisioning (Part B).

---

## 🧱 Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- H2 (in-memory DB)
- Spring Security (basic setup)
- Swagger UI (for API testing)
- GitHub Actions (for CI)
- Maven

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Java 17+
- Maven 3.x
- Git

---

### 🛠️ Build & Run Locally

```bash
# Clone the repo
git clone https://github.com/pareshmishra23/delta-service.git
cd delta-service

# Build
./mvnw clean install

# Run
./mvnw spring-boot:run

#Access API Documentation
#Once the app is running, open:

http://localhost:8080/swagger-ui/index.html

#Security
Basic auth is configured (temporary setup)

Default user/password can be updated in application.properties

# strcuture 
src/
 └── main/
     ├── java/
     ├── resources/
     │   └── application.properties
 .github/workflows/
     └── maven.yml

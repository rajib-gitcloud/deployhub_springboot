# DeployHub Spring Boot Backend

[![DeployHub Compatible](https://img.shields.io/badge/DeployHub-Ready-brightgreen.svg)](https://deployhub.dev)
[![Framework](https://img.shields.io/badge/Framework-Spring%20Boot%203.2+-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Language](https://img.shields.io/badge/Language-Java%2021-orange.svg)]()
[![Build](https://img.shields.io/badge/Build-Maven-red.svg)]()

Enterprise-grade Spring Boot 3 REST API starter template with Spring Actuator monitoring, Java 21 Record models, and Docker multi-stage build.

---

## 🚀 Quick Reference

- **Language / Runtime**: Java 21 / Maven
- **Framework**: Spring Boot 3.2+
- **Monitoring**: Spring Boot Actuator (`/actuator/health`)
- **Default Port**: `8080`
- **Health Check**: `GET /api/health`

---

## 📁 Project Structure

```text
deployhub_springboot/
├── src/
│   ├── main/
│   │   ├── java/com/deployhub/springboot/
│   │   │   ├── controller/
│   │   │   │   ├── HealthController.java
│   │   │   │   └── ItemController.java
│   │   │   ├── model/
│   │   │   │   └── Item.java
│   │   │   └── Application.java
│   │   └── resources/
│   │       └── application.yml
├── deployhub.json           # DeployHub deployment manifest
├── DEPLOYMENT.md            # Cloud deployment guide
├── Dockerfile               # Multi-stage Maven + Temurin JRE build
├── pom.xml
├── .env.example
└── README.md
```

---

## 🛠 Local Setup & Running

```bash
# 1. Build package with Maven
mvn clean package -DskipTests

# 2. Run JAR
java -jar target/deployhub-springboot-1.0.0.jar
```

---

## 🐳 Docker Execution

```bash
# Build container image
docker build -t deployhub-springboot:latest .

# Run container
docker run -d -p 8080:8080 --name springboot_backend deployhub-springboot:latest
```

Test endpoint: `curl http://localhost:8080/api/health`

# Deployment Guide: Spring Boot on DeployHub

This guide details configuring and launching `deployhub_springboot` on DeployHub.

## ⚙️ Configuration Manifest

```json
{
  "name": "deployhub_springboot",
  "framework": "Spring Boot",
  "runtime": "java",
  "port": 8080,
  "buildCommand": "mvn clean package -DskipTests",
  "startCommand": "java -jar target/deployhub-springboot-1.0.0.jar",
  "healthCheck": {
    "path": "/api/health",
    "expectedStatus": 200,
    "timeoutSeconds": 15
  }
}
```

## 🔐 Environment Variables

| Variable | Required | Default | Description |
| :--- | :-: | :--- | :--- |
| `PORT` | No | `8080` | Server listening port |
| `SPRING_PROFILES_ACTIVE` | No | `prod` | Spring profile active |

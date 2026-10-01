package com.deployhub.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class HealthController {

    @GetMapping({"/", "/api/health"})
    public ResponseEntity<Map<String, Object>> health() {
        return ResponseEntity.ok(Map.of(
            "status", "healthy",
            "service", "deployhub_springboot",
            "framework", "Spring Boot 3.2.4",
            "java_version", System.getProperty("java.version"),
            "timestamp", Instant.now().toString()
        ));
    }

    @GetMapping("/api/info")
    public ResponseEntity<Map<String, Object>> info() {
        return ResponseEntity.ok(Map.of(
            "app_name", "DeployHub Spring Boot Backend",
            "version", "1.0.0",
            "description", "Enterprise Java REST API with Spring Boot 3, Actuator, and embedded Tomcat.",
            "endpoints", List.of(
                Map.of("path", "/", "method", "GET", "desc", "Root health check"),
                Map.of("path", "/api/health", "method", "GET", "desc", "Detailed health status"),
                Map.of("path", "/actuator/health", "method", "GET", "desc", "Spring Actuator health probe"),
                Map.of("path", "/api/items", "method", "GET", "desc", "List sample items")
            )
        ));
    }
}

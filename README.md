# 📡 Spring gRPC Backend Service

A lightweight, high-performance backend service built with **Spring Boot** and **gRPC**, designed for low-latency, contract-first communication between microservices.

---

## 🚀 Features

- ✅ gRPC with Protobuf for fast, strongly-typed RPC communication
- ✅ Spring Boot integration for robust configuration and dependency management
- ✅ API contract-first development using `.proto` files
- ✅ Dockerized and cloud-ready
- ✅ Centralized logging and exception handling
- ✅ Health check & metrics endpoints (via Spring Actuator)

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot 3.x
- gRPC / Protobuf
- Maven
- Docker
- Spring Actuator (for health and metrics)
- Optional: Prometheus & Grafana

---



---

## 📜 Example `.proto` Definition

Place your `.proto` files in `src/main/proto/`:

```proto
syntax = "proto3";

package com.example;

option java_multiple_files = true;
option java_package = "com.example.grpc";
option java_outer_classname = "StockTradingProto";

service StockTradingService {
  rpc getStockPrice(StockRequest) returns (StockResponse);
}

message StockRequest {
  string symbol = 1;
}

message StockResponse {
  string symbol = 1;
  double price = 2;
  string timestamp = 3;
}
```

> **Note:** Protobuf stubs will be generated under `target/generated-sources` after build.

---

## 🔧 Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- Docker (optional)

### Clone & Build

```bash
git clone https://github.com/samwanjo41/spring-grpc-backend-sample.git
cd spring-grpc-backend

# Build and compile proto files
mvn clean install
```

### Run the Service

```bash
mvn spring-boot:run
```

> The service will start on gRPC port `6565` by default.

---

## 🧪 Testing the gRPC Service

### With `grpcurl`

```bash
grpcurl -plaintext localhost:6565 list
grpcurl -d '{"symbol":"AAPL"}' -plaintext localhost:6565 com.example.StockTradingService/getStockPrice
```

### With BloomRPC

Import your `.proto` file and test endpoints with a GUI.

---

## 🐳 Docker Support

### `Dockerfile`

```Dockerfile
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/spring-grpc-backend-*.jar app.jar
EXPOSE 6565
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Build & Run

```bash
docker build -t spring-grpc-backend .
docker run -p 6565:6565 spring-grpc-backend
```

---

## 📈 Health & Monitoring

Enable actuator in `application.yml`:

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health, info
  endpoint:
    health:
      show-details: always
```

### Access Health Endpoint

```
GET http://localhost:8080/actuator/health
```

---

## 📦 Deployment Options

This service is suitable for:

- ✅ Docker & Docker Compose
- ✅ Kubernetes
- ✅ Spring Cloud Gateway
- ✅ Cloud platforms (e.g. AWS ECS, GCP Cloud Run)

---



## 🙋‍♂️ Maintainer

**Samuel Wanjohi**  
Backend Developer | Spring Boot & gRPC Enthusiast 
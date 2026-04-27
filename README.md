# 📏 Quantity Measurement Application

## 📌 Overview
This project implements a complete **Quantity Measurement System** from UC1 to UC17.

It supports:
- Length, Weight, Volume, Temperature
- Unit conversions
- Equality checks
- Arithmetic operations
- Spring Boot REST APIs
- Database persistence using JPA (H2)

---

## 🚀 Features
- Generic design using `IMeasurable`
- Type-safe `Quantity<U>` class
- Clean architecture (Controller → Service → Repository)
- Spring Boot + JPA integration
- H2 in-memory database
- REST API endpoints

---

## 🧱 Project Structure
src/
 └── main/
     ├── java/com/bridgelabz/
     │   ├── controller/
     │   ├── service/
     │   ├── repository/
     │   ├── entity/
     │   ├── util/
     │   └── exception/
     └── resources/

---

# 📘 USE CASE IMPLEMENTATION (UC1 → UC17)

## 🔹 UC1 – Basic Equality
- Compare two values in same unit
- Example: `1 ft == 1 ft`

## 🔹 UC2 – Refactor
- Removed duplication
- Improved structure

## 🔹 UC3 – Cross Unit Comparison
- Example:
  - `1 ft == 12 in`

## 🔹 UC4 – Standard Conversion
- Added conversion logic for length units

## 🔹 UC5 – Addition
- Example:
  - `1 ft + 2 in`

## 🔹 UC6 – Yard Support
- `1 yard = 3 ft`

## 🔹 UC7 – Centimeter Support
- `1 inch = 2.54 cm`

## 🔹 UC8 – Volume Measurement
- Liter and Gallon added
- `1 gallon = 3.78 liters`

## 🔹 UC9 – Weight Measurement
- Units:
  - kg (base)
  - g
  - lb

## 🔹 UC10 – Generic Quantity Class
- Introduced:
  - `Quantity<U>`
- Supports:
  - equals()
  - add()
  - conversion()

## 🔹 UC11 – Temperature
- Units:
  - Celsius
  - Fahrenheit
- Conversion:
  - °F = (°C × 9/5) + 32

## 🔹 UC12 – Type Safety
- Prevent cross-category comparison
- Example:
  - Length ≠ Weight

## 🔹 UC13 – Interface Design
- Introduced `IMeasurable`

## 🔹 UC14 – N-Tier Architecture
- Layers:
  - Controller
  - Service
  - Repository

## 🔹 UC15 – Exception Handling
- Custom exceptions:
  - QuantityMeasurementException
  - DatabaseException

## 🔹 UC16 – Database Integration
- H2 database added
- Entity:
  - QuantityMeasurementEntity
- Fields:
  - value
  - unit
  - operation
  - result

## 🔹 UC17 – Spring Boot + JPA Integration
- JpaRepository used
- REST APIs created

### API Endpoints

POST /api/quantity  
→ Save measurement  

GET /api/quantity  
→ Get all measurements  

GET /api/quantity/count  
→ Get total count  

---

## 🛠️ Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- Maven
- H2 Database

---

## ▶️ Run Application
mvn clean install  
mvn spring-boot:run  

---

## 🌐 Access
API: http://localhost:8080/api/quantity  
H2 Console: http://localhost:8080/h2-console  

---

## 🧪 Testing
- JUnit tests implemented
- All use cases verified

---

## 📌 Conclusion
This project demonstrates:
- Generic programming
- Clean architecture
- REST API development
- Database integration using Spring Boot

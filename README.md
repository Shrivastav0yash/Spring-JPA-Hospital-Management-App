# 🏥 Spring JPA Hospital Management App

A **Spring Boot REST API** for managing hospital operations, including patients, doctors, and appointments.
This project is built using **Spring Boot** and **Spring Data JPA** to demonstrate real-world backend development and database relationships.

---

## 🚀 Features

* 👤 Manage Patients (Create, View, Delete)
* 👨‍⚕️ Manage Doctors (Create, View)
* 📅 Manage Appointments (Schedule, View, Delete)
* 🔗 Entity Relationships using JPA (`@ManyToOne`)
* 🗄️ MySQL Database Integration
* 📡 RESTful API Design

---

## 🧠 Tech Stack

* **Java 21+**
* **Spring Boot**
* **Spring Data JPA (Hibernate)**
* **MySQL**
* **Maven**

---

## 🏗️ Project Structure

```
src/main/java/com/springjpa/hospital_management_app
│
├── controller      # REST Controllers (API layer)
├── service         # Business logic
├── repository      # JPA Repositories
├── entity          # JPA Entities (Database tables)
└── HospitalManagementApp.java
```

---

## 🗃️ Database Schema

### 📊 ER Diagram
<img width="1536" height="1024" alt="ER Diagram" src="https://github.com/user-attachments/assets/0e239266-c10c-4474-a680-1d06084a61f4" />

### Entities:

* **Patient**

  * id
  * name
  * age
  * disease

* **Doctor**

  * id
  * name
  * specialization

* **Appointment**

  * id
  * date
  * patient (Many-to-One)
  * doctor (Many-to-One)

---

## 🔗 API Endpoints

### 👤 Patient APIs

* `POST /patients` → Create patient
* `GET /patients` → Get all patients

---

### 👨‍⚕️ Doctor APIs

* `POST /doctors` → Create doctor
* `GET /doctors` → Get all doctors

---

### 📅 Appointment APIs

* `POST /appointments` → Create appointment
* `GET /appointments` → Get all appointments
* `DELETE /appointments/{id}` → Delete appointment

---

## ⚙️ Configuration

### 📄 application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

---

## 🛠️ Setup & Run

### 1️⃣ Clone Repository

```
git clone https://github.com/your-username/Spring-JPA-Hospital-Management-App.git
```

### 2️⃣ Navigate to Project

```
cd Spring-JPA-Hospital-Management-App
```

### 3️⃣ Create Database

```
CREATE DATABASE hospital_db;
```

### 4️⃣ Run Application

```
./mvnw spring-boot:run
```

---

## 🧪 Testing APIs

Use **Postman** or any API client.

Example request:

```
POST /appointments
```

```
{
  "date": "2026-03-20",
  "patient": {
    "id": 1
  },
  "doctor": {
    "id": 1
  }
}
```

---

## ⚠️ Notes

* Make sure MySQL is running before starting the application
* Update username/password in `application.properties`
* Tables will be auto-created using `ddl-auto=update`

---

## 🚀 Future Improvements

* 🔐 Add Authentication (Spring Security / JWT)
* 🔄 Add Update APIs
* 📄 Pagination & Sorting
* 📦 DTO Layer (for clean API responses)
* 🧪 Unit & Integration Testing

---

## 👨‍💻 Author

YASH SHRIVASTAV

Developed as part of learning **Spring Boot + Spring Data JPA** with real-world project implementation.

---

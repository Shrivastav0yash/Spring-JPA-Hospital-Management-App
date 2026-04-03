# 🏥 Spring Boot Hospital Management App

A **backend REST API project** built using **Spring Boot**, **Spring Data JPA**, **MySQL**, and **Spring Security** to simulate a hospital management system.

This project is designed to practice **real-world backend development concepts** such as:

- Layered Architecture
- DTO-based API Design
- Entity Relationships with JPA/Hibernate
- Transaction Management
- RESTful API Development
- Spring Security Integration
- Clean Service-Repository Pattern
- MySQL Database Integration

---

## 🚀 Project Overview

This application manages different hospital-related operations such as:

- **Admin operations**
- **Patient operations**
- **Doctor operations**
- **Appointment management**
- **Insurance association**
- **Department-based doctor structure**
- **Secure backend API setup**

The project is structured in a way that resembles how backend services are typically built in real-world applications.

---

## ✨ Features

### 👨‍💼 Admin Features
- Health check endpoint
- Fetch all registered patients
- Onboard new doctors into the hospital

### 🏥 Hospital Features
- Fetch all doctors available in the hospital

### 👨‍⚕️ Doctor Features
- View all appointments assigned to a specific doctor

### 🧑‍🤝‍🧑 Patient Features
- Create a new appointment
- View patient profile
- View all appointments of a patient

### 📅 Appointment Features
- Create appointment between patient and doctor
- Reassign appointment to another doctor *(service logic implemented)*

### 🛡️ Insurance Features
- Assign insurance to a patient
- Remove/disassociate insurance from a patient

### 🔐 Security Features
- Spring Security integrated
- Secured backend setup
- Foundation prepared for authentication and authorization enhancements

---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security**
- **Hibernate**
- **MySQL**
- **Lombok**
- **ModelMapper**
- **Maven**

---

## 🧱 Architecture

This project follows a **layered architecture**:

```text
Controller Layer  → Handles HTTP Requests / API Endpoints
Service Layer     → Contains Business Logic
Repository Layer  → Database Access using Spring Data JPA
Entity Layer      → JPA Entity Classes (Database Tables)
DTO Layer         → Clean Request/Response Data Transfer Objects
Config Layer      → Bean and Application Configuration
```

This structure helps keep the project **clean, scalable, and maintainable**.

---

## 📁 Project Structure

```bash
src/main/java/com/springjpa/hospital_management_app
│
├── config          # Configuration classes (e.g. ModelMapper / Security Config)
├── controller      # REST API Controllers
├── dto             # Request & Response DTOs
├── entity          # JPA Entity Classes
│   └── type        # Enum / custom types
├── repository      # JPA Repositories
├── services        # Business Logic Layer
└── HospitalManagementApp.java
```

---

## 🧾 DTOs Used

This project uses **DTOs (Data Transfer Objects)** to avoid directly exposing entities in API responses.

### DTOs currently used include:

- `AppointmentResponseDTO`
- `BloodGroupCountResponseEntity`
- `CreateAppointmentDTO`
- `DoctorAppointmentsDTO`
- `DoctorNameResponseDTO`
- `DoctorResponseDTO`
- `OnboardNewDoctorDTO`
- `PatientAppointmentResponseDTO`
- `PatientNameDTO`
- `PatientResponseDTO`

### Why DTOs are used:
- Cleaner API responses
- Better separation between database models and API contracts
- Safer and more scalable backend design

---

## 🗃️ Database Schema

### 📊 ER Diagram
<img width="1536" height="1024" alt="ER Diagram" src="https://github.com/user-attachments/assets/0e239266-c10c-4474-a680-1d06084a61f4" />

## 🗃️ Domain Model / Entities

The application currently includes the following core entities:

### Main Entities
- **Patient**
- **Doctor**
- **Appointment**
- **Insurance**
- **Department**

### Supporting Types
- **BloodGroupType** *(Enum / Type)*

---

## 🔗 Entity Relationships

This project uses **JPA/Hibernate relationships** to model real-world hospital data.

### Key Relationships
- One **Patient** can have multiple **Appointments**
- One **Doctor** can have multiple **Appointments**
- One **Patient** can be associated with **Insurance**
- A **Doctor** can belong to a **Department**
- `Appointment` acts as a linking entity between **Patient** and **Doctor**

This makes the project more realistic than a simple flat CRUD application.

---

## 🔌 API Endpoints

---

# 👨‍💼 Admin APIs

### Base Path:
```http
/admin
```

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/admin/All-OK` | Health check endpoint |
| GET | `/admin/all-patients` | Fetch all registered patients |
| POST | `/admin/onboardNewDoctor` | Add a new doctor to the hospital |

---

# 🏥 Hospital APIs

### Base Path:
```http
/hospital
```

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/hospital/all-doctors` | Fetch all doctors in the hospital |

---

# 👨‍⚕️ Doctor APIs

### Base Path:
```http
/doctor
```

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/doctor/{doctorId}/appointments` | Get all appointments of a specific doctor |

---

# 🧑 Patient APIs

### Base Path:
```http
/patient
```

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/patient/create-Appointment` | Create a new appointment |
| GET | `/patient/{id}` | Get patient profile and appointment details |

---

## 📌 Current Functional Flow

### Admin can:
- check if API is healthy
- view all patients
- onboard doctors

### Patient can:
- book appointment
- view own profile and appointments

### Doctor can:
- view appointments assigned to them

### Hospital can:
- fetch doctor list

---

## 🧠 Business Logic Highlights

This project includes useful backend logic beyond simple CRUD:

- Prevent duplicate doctor onboarding using **name + email**
- Fetch patient profile with associated appointments
- Fetch doctor-specific appointment lists
- Create appointment by linking existing patient and doctor
- Reassign appointments to another doctor
- Associate / disassociate insurance from patient
- DTO mapping using **ModelMapper**
- Uses `@Transactional` in service layer where needed

---

## 🔐 Spring Security

Spring Security has been integrated into this project.

### Security-related points:
- Spring Security dependency is added
- Project is prepared for secure API access
- Security foundation has been set up for backend protection

### Future security enhancements can include:
- Role-based access control (`ADMIN`, `DOCTOR`, `PATIENT`)
- Basic Authentication / Form Login
- JWT Authentication
- Endpoint-level authorization
- Custom UserDetailsService
- Password encryption with BCrypt

> If security rules are still under active development, this section can evolve as the project grows.

---

## ⚙️ Configuration

The application uses **YAML configuration**.

Example structure:

```yaml
spring:
  application:
    name: Chapter-8-Spring-JPA

  datasource:
    url: jdbc:mysql://localhost:3306/spring_jpa_hospital_db
    username: root
    password: your_password

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    defer-datasource-initialization: true

  sql:
    init:
      mode: never
      data-locations: classpath:data.sql
```

> Make sure your actual `application.yml` is **not pushed publicly** if it contains sensitive local credentials.

---

## ▶️ Setup & Run

### 1. Clone the repository

```bash
git clone https://github.com/Shrivastav0yash/Spring-JPA-Hospital-Management-App.git
```

---

### 2. Navigate into the project

```bash
cd Spring-JPA-Hospital-Management-App
```

---

### 3. Create the MySQL database

```sql
CREATE DATABASE spring_jpa_hospital_db;
```

---

### 4. Configure your `application.yml`

Update your local database credentials:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/spring_jpa_hospital_db
    username: root
    password: your_password
```

---

### 5. Run the application

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Or from IntelliJ:
- Open the project
- Run `HospitalManagementApp.java`

---

## 🧪 Sample Request Bodies

### 1) Onboard New Doctor

**POST** `/admin/onboardNewDoctor`

```json
{
  "name": "Dr. Raj Mehta",
  "email": "raj.mehta@example.com",
  "specialization": "Cardiologist"
}
```

---

### 2) Create Appointment

**POST** `/patient/create-Appointment`

```json
{
  "doctorId": 1,
  "patientId": 1,
  "appointmentTime": "2026-04-03T10:30:00",
  "reason": "Chest pain"
}
```

---

## 📤 Sample Responses

### Get All Doctors

**GET** `/hospital/all-doctors`

```json
[
  {
    "id": 1,
    "name": "Dr. Raj Mehta",
    "specialization": "Cardiologist"
  }
]
```

---

### Get Patient Profile

**GET** `/patient/1`

```json
{
  "id": 1,
  "name": "Yash",
  "appointments": [
    {
      "doctorName": "Dr. Raj Mehta",
      "appointmentTime": "2026-04-03T10:30:00",
      "reason": "Chest pain"
    }
  ]
}
```

---

## 📚 Concepts Practiced

This project helped in practicing:

- Spring Boot project setup
- REST API development
- Layered architecture
- DTO-based design
- ModelMapper usage
- JPA entity relationships
- Spring Data JPA repositories
- Transaction handling with `@Transactional`
- MySQL integration
- Service-driven backend logic
- Spring Security integration

---

## 🚧 Future Improvements

Planned / possible improvements:

- Add **Update APIs** using `PUT` / `PATCH`
- Add **Delete APIs** where needed
- Add **Validation** using `@Valid`
- Add **Global Exception Handling**
- Add **Custom Exception Classes**
- Add **JWT Authentication**
- Add **Role-based Authorization**
- Add **Swagger / OpenAPI Documentation**
- Add **Pagination and Sorting**
- Add **Unit and Integration Testing**
- Add **Postman Collection**
- Add **Docker Support**
- Add **Production-ready Profiles**

---

## 👨‍💻 Author

**Yash Shrivastav**

Built as a hands-on backend project to practice:

- Spring Boot
- Spring Data JPA
- DTO Design
- Layered Architecture
- Spring Security
- Real-world backend development concepts

---

## ⭐ If you like this project

Give it a **star** on GitHub and feel free to fork it.

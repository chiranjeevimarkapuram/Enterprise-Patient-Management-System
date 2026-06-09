1. Project Introduction
Project Name

CareSync - Enterprise Patient Management System

Domain

Healthcare Management

Technology Stack
Layer	Technology
Frontend	HTML, CSS, Bootstrap, Thymeleaf
Backend	Spring Boot
ORM	Spring Data JPA, Hibernate
Database	MySQL
Build Tool	Maven
Logging	Log4j2
Validation	Jakarta Validation
Version Control	Git & GitHub
2. Main Agenda of the Project
Problem Statement

In hospitals and clinics, patient information is often managed manually or across multiple systems,
making it difficult to:

Register patients
Maintain medical records
Update patient information
Track patient history
Solution

The CareSync Patient Management System provides a centralized platform to:

Register new patients
View patient records
Update patient details
Delete obsolete records
Store data securely in MySQL
Business Goal

To digitize patient management and reduce manual paperwork while ensuring faster access to patient information.

3. Architecture
User
 |
 V
Browser
 |
 V
Thymeleaf UI
 |
 V
Controller Layer
 |
 V
Service Layer
 |
 V
Repository Layer
 |
 V
Hibernate/JPA
 |
 V
MySQL Database

This follows a Layered Architecture.

4. Project Structure
src/main/java

com.CareSync
│
├── controller
│     └── PatientController
│
├── service
│     └── PatientService
│
├── repository
│     └── PatientRepository
│
├── model
│     └── Patient
│
└── EnterprisePatientManagementSystemApplication

5. Model Layer
Patient Entity
@Entity
@Table(name="patient")
public class Patient
Purpose

Represents a patient record in the database.

Fields
private Long id;
private String name;
private Integer age;
private String email;
private String medicalHistory;

Database Table
patient
Column
id
name
age
email
medical_history

6. Repository Layer

@Repository
public interface PatientRepository
extends JpaRepository<Patient, Long>
Purpose

Provides database operations.

Built-in Methods
findAll()
findById()
save()
deleteById()
count()

No SQL queries needed because Spring Data JPA generates them automatically.

7. Service Layer
@Service
public class PatientService
Purpose

Contains business logic.

Acts as a bridge between:

Controller
    ↓
Service
    ↓
Repository

Methods
Get all patients -> getAllPatients()
Save patient ->savePatient()
Get patient by ID ->getPatientById()
Delete patient -> deletePatient()

8. Controller Layer
@Controller
@RequestMapping("/patients")
Purpose

Handles HTTP requests.

View Patients
@GetMapping

URL:

/patients

Returns:

patients.html
Create Patient Form
@GetMapping("/new")

URL:

/patients/new

Returns:

create_patient.html
Save Patient
@PostMapping("/save")

URL:

/patients/save

Stores patient in database.

Edit Patient
@GetMapping("/edit/{id}")

URL Example:

/patients/edit/1

Loads existing patient data.

Returns:

update_patient.html
Delete Patient
@GetMapping("/delete/{id}")

Deletes selected patient.

9. Frontend Pages
patients.html
Purpose

Displays all patients.

Features:

View records
Edit record
Delete record
Add new patient
create_patient.html
Purpose

Patient Registration Form

Fields:

Name
Age
Email
Medical History
update_patient.html
Purpose

Modify existing patient information.

Loads data automatically.

Uses:

<input type="hidden" th:field="*{id}">

to preserve primary key.

10. Database Flow
Step 1

User enters patient details.

Step 2

Request goes to:

@PostMapping("/save")
Step 3

Controller calls:

patientService.savePatient()
Step 4

Service calls:

patientRepository.save()
Step 5

Hibernate converts object into SQL.

Example:

INSERT INTO patient
(name, age, email, medical_history)
VALUES (...)
Step 6

Data stored in MySQL.

11. CRUD Operations

CRUD means:

Operation	Method
Create	-> savePatient()
Read	->   getAllPatients()
Update	-> update_patient.html + savePatient()
Delete	-> deletePatient()

This project is a complete CRUD application.

12. Why Spring Data JPA?

Without JPA:

Connection con = DriverManager.getConnection();
PreparedStatement ps = ...

Many lines of code.

With JPA:

patientRepository.save(patient);

Single line.

Benefits:

Less code
Faster development
Automatic query generation
13. Why Thymeleaf?

Thymeleaf integrates directly with Spring Boot.

Example:

<td th:text="${patient.name}"></td>

Dynamically displays data from backend.

14. Challenges Faced


During development, I faced issues with Thymeleaf field binding because entity field names and HTML form 
field names were inconsistent. I resolved this by aligning the entity attributes with Thymeleaf expressions 
and validating the controller-to-view flow.


15. Future Enhancements

Security

Implement:

Spring Security
JWT Authentication
Role-Based Access Control

Appointment Management
Doctor Scheduling
Appointment Booking
Appointment History

Reporting
Patient Analytics Dashboard
Power BI Integration

Notifications
Email Notifications
SMS Alerts


CareSync is a healthcare management application developed using Spring Boot, Spring Data JPA, Hibernate, Thymeleaf, and MySQL.
The objective of the project is to digitize patient record management by providing functionalities such as patient registration, 
viewing records, updating information, and deleting records. The application follows a layered architecture consisting of Controller,
Service, Repository, and Database layers. Spring Data JPA is used for database operations, while Thymeleaf is used to render dynamic web pages.
The project implements complete CRUD operations and demonstrates concepts such as MVC architecture, ORM, dependency injection, form validation, 
and database integration. This project helped me gain practical experience in full-stack Java development and enterprise application design.

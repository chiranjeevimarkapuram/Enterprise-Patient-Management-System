package com.CareSync.Enterprise.Patient.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Patient name is required")
    @Column(name = "patient_name")
    private String patientName;

    @Min(value = 1, message = "Age must be greater than 0")
    private Integer age;

    @Email(message = "Invalid email format")
    @Column(name = "email_id")
    private String emailId;

    private String medicalHistory;
}
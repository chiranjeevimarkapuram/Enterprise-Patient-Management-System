package com.CareSync.Enterprise.Patient.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;

    @NotBlank(message = " Patient Name is required ")
    private String patient_name;

    private Integer age;
    private String email_id;
    private Stirng medicalHistory;

}

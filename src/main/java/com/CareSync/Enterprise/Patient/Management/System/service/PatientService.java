package com.CareSync.Enterprise.Patient.Management.System.service;

import com.CareSync.Enterprise.Patient.Management.System.PatientRepository.PatientRepository;
import com.CareSync.Enterprise.Patient.Management.System.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {


    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }
}

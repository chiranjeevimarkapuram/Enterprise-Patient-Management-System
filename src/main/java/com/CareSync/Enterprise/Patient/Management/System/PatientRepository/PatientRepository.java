package com.CareSync.Enterprise.Patient.Management.System.PatientRepository;

import com.CareSync.Enterprise.Patient.Management.System.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {


}

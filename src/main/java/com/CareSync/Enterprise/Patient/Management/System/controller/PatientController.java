package com.CareSync.Enterprise.Patient.Management.System.controller;

import com.CareSync.Enterprise.Patient.Management.System.model.Patient;
import com.CareSync.Enterprise.Patient.Management.System.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Display all patients
    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("listPatients",
                patientService.getAllPatients());

        return "patients";
    }

    // Show create form
    @GetMapping("/new")
    public String showNewPatientForm(Model model) {

        model.addAttribute("patient", new Patient());

        return "create_patient";
    }

    // Save patient
    @PostMapping("/save")
    public String savePatient(
            @Valid @ModelAttribute("patient") Patient patient,
            BindingResult result) {

        if (result.hasErrors()) {
            return "create_patient";
        }

        patientService.savePatient(patient);

        return "redirect:/patients";
    }

    // Edit form
    @GetMapping("/patients/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        Patient patient = patientService.getPatientById(id);

        model.addAttribute("patient", patient);

        return "edit-patient";
    }

    // Delete patient
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
}
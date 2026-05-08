//package com.example.hospitalmanagemet.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.hospitalmanagemet.entity.Patient;
//import com.example.hospitalmanagemet.repository.PatientRepository;
//
//@RestController
//@RequestMapping("/patients")
//public class PatientController {
//
//    @Autowired PatientRepository repo;
//
//    @PostMapping
//    public Patient save(@RequestBody Patient p) {
//        return repo.save(p);
//    }
//
//    @GetMapping
//    public List<Patient> getAll() {
//        return repo.findAll();
//    }
//}


package com.example.hospitalmanagemet.controller;

import com.example.hospitalmanagemet.entity.Patient;
import com.example.hospitalmanagemet.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // ➕ Add patient
    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    // 📄 Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // 🔍 Get patient by ID
    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

    // ❌ Delete patient
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "Patient deleted successfully";
    }
}


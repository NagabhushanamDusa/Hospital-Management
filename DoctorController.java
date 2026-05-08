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
//import com.example.hospitalmanagemet.entity.Doctor;
//import com.example.hospitalmanagemet.repository.DoctorRepository;
//
//@RestController
//@RequestMapping("/doctors")
//public class DoctorController {
//
//    @Autowired DoctorRepository repo;
//
//    @PostMapping
//    public Doctor save(@RequestBody Doctor d) {
//        return repo.save(d);
//    }
//
//    @GetMapping
//    public List<Doctor> getAll() {
//        return repo.findAll();
//    }
//}


package com.example.hospitalmanagemet.controller;

import com.example.hospitalmanagemet.entity.Doctor;
import com.example.hospitalmanagemet.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // ➕ Add doctor
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    // 📄 Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // 🔍 Get doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id) {
        return doctorService.getDoctor(id);
    }

    // ❌ Delete doctor
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "Doctor deleted successfully";
    }
}


//package com.example.hospitalmanagemet.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.hospitalmanagemet.entity.Appointment;
//import com.example.hospitalmanagemet.repository.AppointmentRepository;
//
//@RestController
//@RequestMapping("/appointments")
//public class AppointmentController {
//
//    @Autowired AppointmentRepository repo;
//
//    @PostMapping
//    public Appointment book(@RequestBody Appointment a) {
//        return repo.save(a);
//    }
//}


package com.example.hospitalmanagemet.controller;

import com.example.hospitalmanagemet.entity.Appointment;
import com.example.hospitalmanagemet.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // ➕ Book appointment
    @PostMapping
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(appointment);
    }

    // 📄 Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // 🔍 Get appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }

    // ❌ Cancel appointment
    @DeleteMapping("/{id}")
    public String cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return "Appointment cancelled successfully";
    }
}

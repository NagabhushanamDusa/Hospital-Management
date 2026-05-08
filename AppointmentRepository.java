package com.example.hospitalmanagemet.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalmanagemet.entity.Appointment;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Optional: Get all appointments by patient
    List<Appointment> findByPatientId(Long patientId);

    // Optional: Get all appointments by doctor
    List<Appointment> findByDoctorId(Long doctorId);
}

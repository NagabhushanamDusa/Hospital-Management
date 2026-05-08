package com.example.hospitalmanagemet.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalmanagemet.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    // JpaRepository provides all CRUD operations
}


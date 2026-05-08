package com.example.hospitalmanagemet.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalmanagemet.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // JpaRepository provides CRUD operations for doctors
}

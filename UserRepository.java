package com.example.hospitalmanagemet.repository;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalmanagemet.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

	com.example.smartbank.entity.User save(com.example.smartbank.entity.User user);
}

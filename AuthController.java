package com.example.hospitalmanagemet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalmanagemet.dto.LoginRequest;
import com.example.hospitalmanagemet.dto.RegisterRequest;
import com.example.hospitalmanagemet.entity.User;
import com.example.hospitalmanagemet.repository.UserRepository;
import com.example.hospitalmanagemet.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired UserRepository repo;
    @Autowired PasswordEncoder encoder;
    @Autowired JwtUtil jwt;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest r) {
        User u = new User();
        u.setUsername(r.getUsername());
        u.setPassword(encoder.encode(r.getPassword()));
        u.setRole(r.getRole());
        repo.save(u);
        return "Registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest r) {
        User u = repo.findByUsername(r.getUsername()).orElseThrow();
        if (encoder.matches(r.getPassword(), u.getPassword())) {
            return jwt.generateToken(u.getUsername());
        }
        throw new RuntimeException("Invalid credentials");
    }
}

//package com.example.hospitalmanagemet.controller;
//
//import com.example.hospitalmanagemet.entity.User;
//import com.example.hospitalmanagemet.security.JwtUtil;
//import com.example.hospitalmanagemet.service.UserService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    // ✅ Register
//    @PostMapping("/register")
////  public String register(@RequestBody RegisterRequest r) {
////      User u = new User();
////      u.setUsername(r.getUsername());
////      u.setPassword(encoder.encode(r.getPassword()));
////      u.setRole(r.getRole());
////      repo.save(u);
////      return "Registered";
////  }
//
//    // ✅ Login
//    @PostMapping("/login")
//    public Map<String, String> login(@RequestBody User request) {
//
//        User user = userService.getByUsername(request.getUsername());
//
//        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Invalid username or password");
//        }
//
//        String token = jwtUtil.generateToken(user.getUsername());
//
//        Map<String, String> response = new HashMap<>();
//        response.put("token", token);
//
//        return response;
//    }
//}





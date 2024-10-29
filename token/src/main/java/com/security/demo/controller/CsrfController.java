package com.security.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CsrfController {

    @GetMapping("/csrf")
    public CsrfToken csrf(HttpServletRequest request) {
       
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }


    @GetMapping("/students")
    public ResponseEntity<Map<String, Object>> getStudents() {
        Map<String, Object> response = new HashMap<>();
        response.put("id", 1);
        response.put("name", "Jonny");
        response.put("age", 21);
        response.put("message", "Student data retrieved successfully.");
        
        return ResponseEntity.ok(response);
    }

    
    @PostMapping("/students")
    public ResponseEntity<Map<String, Object>> createStudent(@RequestBody Map<String, Object> studentData) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", 1);
        response.put("name", studentData.get("name"));
        response.put("age", studentData.get("age"));
        response.put("message", "Student created successfully.");
        
        return ResponseEntity.ok(response);
    }
}

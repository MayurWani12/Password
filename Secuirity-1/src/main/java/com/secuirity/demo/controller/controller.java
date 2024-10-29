package com.secuirity.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class controller {
	@GetMapping("/normal")
	public ResponseEntity<String> normalUser(){
		return ResponseEntity.ok("i am normal");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser(){
		return ResponseEntity.ok("i am admoin");
	}
	@GetMapping("/public")
	public ResponseEntity<String> publicUser(){
		return ResponseEntity.ok("i am public");
	}

}

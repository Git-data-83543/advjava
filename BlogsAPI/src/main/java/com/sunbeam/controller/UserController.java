package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.AdhaarCardAndLanguagesDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.UserReqDTO;
import com.sunbeam.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in ctor " + getClass());
	}
	@PostMapping("/signin")
	public ResponseEntity<?> signInUser(@RequestBody AuthRequest request) {
		System.out.println("in signin " + request);
		try {
			return ResponseEntity.ok(userService.authenticateUser(request));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> reigster(@RequestBody UserReqDTO request) {
		System.out.println("in signin " + request);
		try {
			return ResponseEntity.ok(userService.addUser(request));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping
	public ResponseEntity<?> fetchUser() {
		try {
			return ResponseEntity.ok(userService.allUser());
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	@GetMapping("/{city}")
	public ResponseEntity<?> fetchUser(@RequestParam String city) {
		try {
			return ResponseEntity.ok(userService.allUserByCity(city));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PostMapping("/AdhaarCardAndLanguages")
	public ResponseEntity<?> adhaarCardAndLanguage(@RequestBody AdhaarCardAndLanguagesDTO request) {
		System.out.println("in signin " + request);
		try {
			return ResponseEntity.ok(userService.asignAdhaarCardAndLanguages(request));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	

}

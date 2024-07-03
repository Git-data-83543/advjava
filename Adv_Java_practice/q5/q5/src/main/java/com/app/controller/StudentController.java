package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService serv;
	
	@PostMapping("/student")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.addStudent(student));
	}
	
	@GetMapping("/{cname}")
	public ResponseEntity<?> getStudents(@PathVariable String cname) {
		return ResponseEntity.ok(serv.getStudentByCourse(cname));
	}
	
	@DeleteMapping("/{cname}")
	public ResponseEntity<?> deleteStudent(@PathVariable String cname) {
		return ResponseEntity.ok(serv.deleteStudentByCourse(cname));
	}
	
	
	
}

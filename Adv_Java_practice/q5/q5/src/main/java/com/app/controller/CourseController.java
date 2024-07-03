package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Course;
import com.app.service.CourseService;

@RestController
@RequestMapping("api")
public class CourseController {
	
	@Autowired
	private CourseService serv;
	
	@PostMapping("/course")
	public ResponseEntity<?> addCourse(@RequestBody Course course) {
		return ResponseEntity.ok(serv.addCourse(course));
	}
	
	@DeleteMapping("/{cname}")
	public ResponseEntity<?> deleteCourse(@PathVariable String cname) {
		Course course = serv.getCourse(cname);
		return ResponseEntity.ok(serv.deleteCourse(course));
	}
}

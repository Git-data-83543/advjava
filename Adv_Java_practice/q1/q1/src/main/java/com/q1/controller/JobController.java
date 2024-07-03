package com.q1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.q1.entities.Job;
import com.q1.service.JobService;


@RestController
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired
	private JobService serv;
	
	@GetMapping("/list")
	public ResponseEntity<?> getJobs() {
		return ResponseEntity.ok(serv.getAllJobs());
	}
	
	@PostMapping("/job")
	public ResponseEntity<?> addJob(@RequestBody Job job) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.addNewJob(job));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateJobs(@PathVariable Long id, @RequestBody Job job) {
		return ResponseEntity.status(HttpStatus.OK).body(serv.updateJob(id, job));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		return ResponseEntity.ok(serv.deleteJob(id));
	}
}

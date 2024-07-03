package com.app.controller;

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

import com.app.dto.JobPostingDto;
import com.app.entity.JobPosting;
import com.app.service.JobPostingService;

@RestController
@RequestMapping("/jobposts")
public class JobPostingController {

		@Autowired
		private JobPostingService service;

		public JobPostingController() {
			System.out.println("in service ctor");;
		}
		
		
		@GetMapping
		public ResponseEntity<?> listAllJobPosts()
		{
			return ResponseEntity.ok(service.getAllJobPosts());
		}
		
		@PostMapping
		public ResponseEntity<?> addNewJobPost(@RequestBody JobPostingDto jpdto)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(service.addNewJobPosting(jpdto));
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<?> updateJobPost(@PathVariable Long id,@RequestBody JobPosting jp)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(service.updateNewJobPosting(id, jp));
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteJobPost(@PathVariable Long id)
		{
			return ResponseEntity.ok(service.deleteJobPosting(id));
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<?> getJobPostId(@PathVariable Long id)
		{
			return ResponseEntity.ok(service.getJobDetails(id));
		}
		
		@GetMapping("/title/{title}")
		public ResponseEntity<?> getAllJobPostsbyTitle(@PathVariable String title)
		{
			return ResponseEntity.ok(service.getJobDetailsByJobTitle(title));
		}
		
}

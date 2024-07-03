package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.CommentDto;
import com.sunbeam.dto.CommentPostDto;
import com.sunbeam.service.CommentService;

import io.swagger.v3.oas.models.responses.ApiResponse;

@RestController
@RequestMapping("/comment")
public class CommentController {
   
	@Autowired
	private CommentService commentService;
	
	@PostMapping
	public ResponseEntity<?> postComment(@RequestBody CommentPostDto commentBody){
		try {
			return ResponseEntity.ok(commentService.postComment(commentBody));	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editComment(@RequestBody CommentDto commentBody){
		try {
			return ResponseEntity.ok(commentService.putComment(commentBody));	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteComment(@RequestParam Long userId){
		try {
			return ResponseEntity.ok(commentService.deleteComment(userId));	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> allComment(){
		try {
			return ResponseEntity.ok(commentService.allComment());	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}

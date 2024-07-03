package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BlogPostReqDTO;
import com.sunbeam.dto.TagAndPostDto;
import com.sunbeam.dto.TagAndPostDto2;
import com.sunbeam.service.BlogPostService;

@RestController
@RequestMapping("/posts")
public class BlogPostController {
	//depcy 
	@Autowired
	private BlogPostService blogPostService;
	
	public BlogPostController() {
		System.out.println("in ctor " + getClass());
	}
	@PostMapping
	public ResponseEntity<?> addBlogPost(@RequestBody BlogPostReqDTO dto) {
		try {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(blogPostService.postNewBlog(dto));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
					
		}	
	}
	
	@GetMapping
	public ResponseEntity<?> fetchAllBLogs(){
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(blogPostService.getAllPost());
			} catch (RuntimeException e) {
				System.out.println(e);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new ApiResponse(e.getMessage()));
						
			}	
	}
   
	@PostMapping("/addtag")
	public ResponseEntity<?> asignTagToPost(@RequestBody TagAndPostDto dto) {
		try {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(blogPostService.addTagAndPost(dto));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
					
		}	
	}
	
	@DeleteMapping("/deletetag")
	public ResponseEntity<?> removeTagToPost(@RequestBody TagAndPostDto2 dto) {
		try {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(blogPostService.deleteTagAndPost(dto));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
					
		}	
	}
}

package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.TagsDTO;
import com.sunbeam.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {
 
	@Autowired
	private TagService tagService;
	
	@GetMapping
	public ResponseEntity<?> allTags(){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(tagService.allTags());
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PostMapping
	public ResponseEntity<?> addTags(@RequestBody TagsDTO tagDto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(tagService.addTags(tagDto));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
}

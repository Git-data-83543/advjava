package com.demo.controller;

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

import com.demo.dtos.ApiResponse;
import com.demo.entities.Reciepe;
import com.demo.service.ReciepeService;

@RestController
@RequestMapping("/recipe/")
public class ReciepeController {
	@Autowired
	private ReciepeService serv;
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		try{
			return ResponseEntity.ok(serv.getReciepeById(id));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Id not found!!"));
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Reciepe reciepe){
		try {
			return ResponseEntity.ok(serv.updateReciepe(id, reciepe));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Id not found!!"));
		}
	}
	
	@PostMapping()
	public ResponseEntity<?> addReciepe(@RequestBody Reciepe reciepe){
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.addReciepe(reciepe));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteReciepe(@PathVariable Long id){
		try {
			return ResponseEntity.ok(serv.deleteReciepe(id));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Id not found!!"));
		}
	}

}

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

import com.app.entity.Vehicle;
import com.app.service.VehicleService;


@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService serv;
	
	@PostMapping("/vehicle")
	public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.addVehicle(vehicle));
	}
	
	@GetMapping("/{uname}")
	public ResponseEntity<?> getVehicles(@PathVariable String uname) {
		return ResponseEntity.ok(serv.getVehicleByUser(uname));
	}
	
	@DeleteMapping("/{uname}")
	public ResponseEntity<?> deleteVehicle(@PathVariable String uname) {
		return ResponseEntity.ok(serv.deleteVehicleByUser(uname));
	}
}

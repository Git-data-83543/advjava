package com.demo.controller;

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

import com.demo.entities.Reservation;
import com.demo.service.ReservationService;

@RestController
@RequestMapping("/")
public class ReservationController {
	
	@Autowired
	private ReservationService serv;
	
	@GetMapping("rooms")
	public ResponseEntity<?> getAvailRooms(){
		return ResponseEntity.ok(serv.getAvailableRooms());
	}

	@PostMapping("reservation")
	public ResponseEntity<?> addReservation(@RequestBody Reservation res){
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.addReservation(res));
	}
	
	@DeleteMapping("{resId}")
	public ResponseEntity<?> delete(@PathVariable Long resId){
		return ResponseEntity.status(HttpStatus.OK).body(serv.deleteReservation(resId));
	}
}

package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Reservation;
import com.app.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	public ReservationController() {
		System.out.println("in ctor " + getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> addNewReservation(@RequestBody Reservation reservation) {
		System.out.println("in add Reservation " + reservation);
		return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.addNewReservation(reservation));
	}
	
	
	
	@GetMapping
	public ResponseEntity<?> getAllReservation() {
		System.out.println("in get all Reservation ");
		return ResponseEntity.status(HttpStatus.OK).body(reservationService.getAllReservation());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateReservation(@PathVariable Long id, Reservation res){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.updateReservation(id, res));
		
	}


}

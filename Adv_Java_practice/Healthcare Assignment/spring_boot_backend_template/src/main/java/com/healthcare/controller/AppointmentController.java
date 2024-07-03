package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dtos.AppointmentDTO;
import com.healthcare.entity.Appointment;
import com.healthcare.service.AppointmentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO){
		System.out.println("In appointment controller ");
		return ResponseEntity.
				status(HttpStatus.CREATED)
				.body(appointmentService.createAppointment(appointmentDTO));
	}
}

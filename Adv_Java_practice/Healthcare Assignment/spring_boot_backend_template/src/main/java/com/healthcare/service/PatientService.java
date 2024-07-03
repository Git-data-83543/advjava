package com.healthcare.service;

import com.healthcare.dtos.ApiResponse;
import com.healthcare.entity.Patient;

public interface PatientService {
	
	ApiResponse  patientLogin(Patient patient);
	
	 
}

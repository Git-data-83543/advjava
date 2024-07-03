package com.healthcare.service;

import com.healthcare.dtos.ApiResponse;
import com.healthcare.dtos.AppointmentDTO;

public interface AppointmentService {

	ApiResponse createAppointment(AppointmentDTO appointmentDTO);
}

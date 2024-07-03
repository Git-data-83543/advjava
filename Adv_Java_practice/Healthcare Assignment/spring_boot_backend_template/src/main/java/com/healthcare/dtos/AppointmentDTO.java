package com.healthcare.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.healthcare.entity.Doctor;
import com.healthcare.entity.Patient;

//@Getter
//@Setter
public class AppointmentDTO extends BaseDTO {

	
	private DoctorDTO doctorDTO;
	private PatientDTO patientDTO;
	private LocalDate dateOfAppointment;
	private LocalTime timeSlot;
	private boolean status = true;
	public DoctorDTO getDoctorDTO() {
		return doctorDTO;
	}
	public void setDoctorDTO(DoctorDTO doctorDTO) {
		this.doctorDTO = doctorDTO;
	}
	public PatientDTO getPatientDTO() {
		return patientDTO;
	}
	public void setPatientDTO(PatientDTO patientDTO) {
		this.patientDTO = patientDTO;
	}
	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	public LocalTime getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(LocalTime timeSlot) {
		this.timeSlot = timeSlot;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
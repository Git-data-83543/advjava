package com.healthcare.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.dtos.ApiResponse;
import com.healthcare.dtos.AppointmentDTO;
import com.healthcare.entity.Appointment;
import com.healthcare.entity.Doctor;
import com.healthcare.entity.Patient;
import com.healthcare.repository.AppoitmentRepository;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.repository.PatientRepository;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppoitmentRepository appoitmentRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public ApiResponse createAppointment(AppointmentDTO appointmentDTO) {
		System.out.println("In appointment service layer -- >"+ appointmentDTO);
		
		if (appointmentDTO == null) {
            throw new RuntimeException("AppointmentDTO is null");
        }
        if (appointmentDTO.getPatientDTO() == null) {
            throw new RuntimeException("PatientDTO is null");
        }
        if (appointmentDTO.getDoctorDTO() == null) {
            throw new RuntimeException("DoctorDTO is null");
        }

		 Patient patient = patientRepository.findById(appointmentDTO.getPatientDTO().getId())
	                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + appointmentDTO.getPatientDTO().getId()));

	        Doctor doctor = doctorRepository.findById(appointmentDTO.getDoctorDTO().getId())
	                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + appointmentDTO.getDoctorDTO().getId()));
		
		Appointment appointment = mapper.map(appointmentDTO,Appointment.class);
		
		appointment.setDateOfAppointment(appointmentDTO.getDateOfAppointment());
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		appointment.setStatus(true);
		appointment.setTimeSlot(appointmentDTO.getTimeSlot());
		
//		AppointmentDTO appointmentDto = new AppointmentDTO();
//		appointmentDto.setDateOfAppointment(appointmentDTO.getDateOfAppointment());
//        appointmentDto.setTimeSlot(appointment.getTimeSlot());
//        appointmentDto.setStatus(appointment.isStatus());
//        appointmentDto.setPatient(patient);
//        appointmentDto.setDoctor(doctor);
        
		appoitmentRepository.save(appointment);
		String msg = "appointment created successfully!";
		return new ApiResponse(msg);
	}

}

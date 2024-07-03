package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.entity.Reservation;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ReservationRepository;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public Reservation addNewReservation(Reservation reservation) {
		
		// TODO Auto-generated method stub
		return reservationRepository.save(reservation);// rets persistent
	}
	
	@Override
	public List<Reservation> getAllReservation()
	{
		return reservationRepository.findAll();
	}
	
	@Override
	public ApiResponse updateReservation(Long id, Reservation obj)
	{
		String msg = "updation failed!!!!!";
		if(reservationRepository.existsById(id)) {
			reservationRepository.save(obj);
			msg="reservation updated successfully!!!";
		}
		else {
			throw new ResourceNotFoundException("Inavalid id!!!");
		}
		
		return new ApiResponse(msg);
	}

}

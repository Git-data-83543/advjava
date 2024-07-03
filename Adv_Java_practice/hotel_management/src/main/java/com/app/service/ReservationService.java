package com.app.service;


import java.util.List;

import com.app.dto.ApiResponse;
import com.app.entity.Reservation;

public interface ReservationService {
//	Category addNewCategory(Category category);
	Reservation addNewReservation(Reservation reservation);
	List<Reservation> getAllReservation();
	
	ApiResponse updateReservation(Long id, Reservation obj);
	
}

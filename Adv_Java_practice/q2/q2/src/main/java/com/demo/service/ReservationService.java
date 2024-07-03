package com.demo.service;

import java.util.List;

import com.demo.dtos.ApiResponse;
import com.demo.entities.Reservation;
import com.demo.entities.Room;

public interface ReservationService {
	
	ApiResponse addReservation(Reservation res);
	
	List<Room> getAvailableRooms();
	
	ApiResponse deleteReservation(Long id);
}

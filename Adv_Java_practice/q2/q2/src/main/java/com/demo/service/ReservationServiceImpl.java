package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dtos.ApiResponse;
import com.demo.entities.Reservation;
import com.demo.entities.Room;
import com.demo.repository.ReservationRepo;
import com.demo.repository.RoomRepo;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private RoomRepo roomRepo;
	
	@Autowired
	private ReservationRepo rrepo;
	
	@Override
	public ApiResponse addReservation(Reservation res) {
		rrepo.save(res);
		Room room = roomRepo.findById(res.getRoom().getRoomid()).orElseThrow();
		room.setIsavail("true");
		return new ApiResponse("Room "+room.getRoomid()+" is reserved!");
	}

	@Override
	public List<Room> getAvailableRooms() {
		return roomRepo.findIsAvail();
	}

	@Override
	public ApiResponse deleteReservation(Long id) {
		Reservation res = rrepo.findById(id).orElseThrow();
		Room room = roomRepo.findById(res.getRoom().getRoomid()).orElseThrow();
		room.setIsavail("false");
		rrepo.delete(res);
		return new ApiResponse("Reservation deleted!!");
	}

}

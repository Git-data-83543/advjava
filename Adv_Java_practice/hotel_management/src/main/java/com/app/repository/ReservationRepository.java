package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long>  {
	
	

}

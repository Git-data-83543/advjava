package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.app.entity.RoomType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {
	
	
	private Long id;
	
	private String guestName;
	
	private LocalDate inDate;
	
	private LocalDate outDate;
	
	private int roomId;
	
	private double totalPrice;

}

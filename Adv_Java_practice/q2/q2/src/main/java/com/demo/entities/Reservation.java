package com.demo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
//Reservation ID, guest name, check-in date, check-out date, room ID, total price.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resid;
	
	private String name;
	
	private LocalDate checkin;
	
	private LocalDate checkout;
	
	private Double totalprice;
	
	@ManyToOne
	@JoinColumn(name = "roomid")
	private Room room;

}

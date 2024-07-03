package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//•	Reservation:Reservation ID, guest name, check-in date, check-out date, room ID, total price.
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="reservations")
public class Reservation {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="guest_name", length=20)
	private String guestName;
	
	@Column(name="check_in_date")
	private LocalDate inDate;
	
	@Column(name="check_out_date")
	private LocalDate outDate;
	
	@Column(name="room_id")
	private int roomId;
	
	@Column(name="total_price")
	private double totalPrice;

}

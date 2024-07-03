package com.app.entity;

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
//import javax.persistence.Table;

//Entities (with attributes):
//•	Room:Room ID, room number, type (single, double, suite), price, availability.



@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="rooms")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="room_no", unique=true)
	private int roomNo;
	
	@Enumerated(EnumType.STRING)
	private RoomType type;
	
	@Column(name="price")
	private double price;
	
	@Column(name="availability")
	private boolean availability;

}

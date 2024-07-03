package com.demo.entities;

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

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "room")
public class Room {
	
	//Room ID, room number, type (single, double, suite), price, availability.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomid;
	
	private Integer roomno;
	
	@Enumerated(EnumType.STRING)
	private Rtype type;
	
	private Double price;
	
	private String isavail;
	
	
	

}

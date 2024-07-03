package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//1) Id (unique identifier for each Projects, auto generated, starts from 1) 
//2) Vname (Cannot be Blank, Example: Splendor, Amaze, Pulsar, etc.) 
//3) Company (Enum, Example: Hero, Honda, Bajaj, etc.) 
//4) Vnumber (Cannot be Blank, Example: MH09AB1111, MH10CD2222, MHEF3333, etc.) 
//5) Vtype (Cannot be Blank, Example: bike, sedan, cruiser, etc.) 
//6) Uid (User ID, FK) 

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "vname")
	private String vname;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "company")
	private Company comp;
	
	@NotNull
	@Column(name = "vnumber")
	private String vnumber;
	
	@NotNull
	@Column(name = "vtype")
	private String vtype;
	
	@ManyToOne
	@JoinColumn(name = "uid")
	private User user;
	
}

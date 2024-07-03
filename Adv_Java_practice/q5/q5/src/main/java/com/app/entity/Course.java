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
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//1. ID (unique identifier for each Course, auto generated, starts from 1) 
//2. Name (Cannot be Blank, Example : JAVA01, JAVA02, WEBJAVA01, WEBJAVA02) 
//3. Category (Enum, Example: JAVA-BEGINER, JAVA-ADVANCED) 
//4. Start Date (Cannot be Blank) 
//5. End Date (Cannot be Blank) 
//6. Fee (Cannot be Blank) 
//7. Grade to Pass (Cannot be Blank) 

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	
	@NotNull
	@Column(name = "cname")
	private String cname;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@NotNull
	@Column(name = "startDate")
	private LocalDate startDate;
	
	@NotNull
	@Column(name = "endDate")
	private LocalDate endDate;
	
	@NotNull
	@Column(name = "fee")
	private Double fee;
	
	@NotNull
	@Column(name = "grade")
	private String grade;
}

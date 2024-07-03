package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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

//1. Sid (unique identifier for each Student) 
//2. Sname (Cannot be Blank) 
//3. Email (Cannot be Blank) 
//4. Password (Cannot be Blank) 
//5. Cid (Course ID, FK) 

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	
	@NotNull
	@Column(name = "sname")
	private String sname;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "passoword")
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private Course course;
	
	
}

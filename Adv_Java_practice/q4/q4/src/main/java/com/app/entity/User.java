package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//1) Uid (unique identifier for each User) 
//2) Uname (Cannot be Blank) 
//3) Email (Cannot be Blank) 
//4) Password (Cannot be blank, min 6 characters) 
//5) City (Cannot be Blank) 
//6) Contact_No (Cannot be blank, min 10 digit) 

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	
	@NotNull
	@Column(name = "uname")
	private String uname;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@Size(min = 6)
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "city")
	private String city;
	
    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    @Column(name = "contact")
	private String contNo;
	
	
	
}

package com.sunbeam.dto;

import java.time.LocalDate;

import com.sunbeam.entities.Role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserReqDTO {
	private String firstName;
	private String lastName;
	private String email;	
	private LocalDate dob;
	private String password;
	private double regAmount;
	private Role role;
}

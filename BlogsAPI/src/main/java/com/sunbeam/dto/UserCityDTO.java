package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCityDTO {
	private String firstName;
	private String lastName;
	private String email;	
	private LocalDate dob;
}

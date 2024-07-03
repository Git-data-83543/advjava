package com.sunbeam.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entities.Role;
import com.sunbeam.value_types.AdhaarCard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRespDTO extends BaseDTO{
	private String firstName;
	private String lastName;
	private String email;	
	private LocalDate dob;
	private double regAmount;
	private Role role;
	private AddressDTO userAddress;
	private AdhaarCard card;
	private List<String> languages;
}

package com.healthcare.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
public class PatientDTO extends BaseDTO{
	
	public String name;
	public String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

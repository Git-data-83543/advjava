package com.healthcare.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
public class BaseDTO {

	

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate creationDate;
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime updationTimeStamp;
	
	public Long getId() {
		return id;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public LocalDateTime getUpdationTimeStamp() {
		return updationTimeStamp;
	}
	
	


}

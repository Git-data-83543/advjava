package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString
public class ApiResponse {
	
	private String msg;
	private LocalDateTime dt;
	
	public ApiResponse(String message) {
		super();
		this.msg = message;
		this.dt = LocalDateTime.now();
	}

		
}

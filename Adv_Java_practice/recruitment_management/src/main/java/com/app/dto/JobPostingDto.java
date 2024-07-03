package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobPostingDto {
	
	private Long id;
	
	private String jobTitle;
	
	private String companyName;
	
	private String location;
	
	private String description;
	
	private int requirements;
	
	private double salary;
	
	private LocalDate postingDate;

}

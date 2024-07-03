package com.app.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Job title, company name, location, description, requirements, salary, and posting date.
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="job_postings")
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="job_title", length=20)
	private String jobTitle;
	
	@Column(name="company_name", length=20)
	private String companyName;
	
	@Column(name="location", length=100)
	private String location;
	
	@Column(name="description", length=200)
	private String description;
	
	@Column(name="requirements", length=20)
	private int requirements;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="posting_date")
	private LocalDate postingDate;
	
	

}

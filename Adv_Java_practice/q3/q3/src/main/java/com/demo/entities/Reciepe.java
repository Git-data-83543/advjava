package com.demo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "reciepe")
public class Reciepe {

	//Recipe ID, title, description, ingredients, instructions, difficulty level, 
	//cuisine type, author (user ID), creation date.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private String ingredients;
	
	private String difficultyLevel;
	
	private String cuisine;
	
	private Long author;
	
	private LocalDate creationDate = LocalDate.now();
}

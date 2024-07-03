package com.healthcare.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass // to tell JPA/Hiberanate -no table creation , it's common base class to inherit
					// other entities
//@NoArgsConstructor
//@Getter
//@Setter

public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //for serializability
	@CreationTimestamp
	@Column(name = "creation_date")
	private LocalDate creationnDate;
	@UpdateTimestamp
	@Column(name = "updation_date")
	private LocalDate updationDate;
	
	public BaseEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getCreationnDate() {
		return creationnDate;
	}
	public void setCreationnDate(LocalDate creationnDate) {
		this.creationnDate = creationnDate;
	}
	public LocalDate getUpdationDate() {
		return updationDate;
	}
	public void setUpdationDate(LocalDate updationDate) {
		this.updationDate = updationDate;
	}
	
}
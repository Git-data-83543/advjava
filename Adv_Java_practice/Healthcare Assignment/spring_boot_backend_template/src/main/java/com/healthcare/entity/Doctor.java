package com.healthcare.entity;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Entity;
//import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "doctors")
public class Doctor extends BaseEntity {
	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 50)
	private String email;
	
//	@OneToMany(mappedBy = "doctor",
//			cascade = CascadeType.ALL,orphanRemoval = true
//	/* ,fetch = FetchType.EAGER */)
//	private List<Appointment> appointments = new ArrayList<>();
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

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

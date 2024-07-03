package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.entity.Appointment;

@Repository
public interface AppoitmentRepository extends JpaRepository<Appointment, Long> {
	
}

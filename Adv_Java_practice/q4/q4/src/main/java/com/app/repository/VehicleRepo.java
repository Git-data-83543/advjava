package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findByUser_Uname(String uname);
}

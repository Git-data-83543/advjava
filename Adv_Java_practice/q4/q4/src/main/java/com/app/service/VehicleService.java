package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.entity.User;
import com.app.entity.Vehicle;
import com.app.repository.UserRepo;
import com.app.repository.VehicleRepo;


@Service
@Transactional
public class VehicleService {
	
	@Autowired
	private VehicleRepo repo;
	
	@Autowired 
	private UserRepo userrepo;
	
	public Vehicle addVehicle(Vehicle vehicle) {
		User user = userrepo.findByUname(vehicle.getUser().getUname());
		vehicle.setUser(user);
		return repo.save(vehicle);
	}
	
	public List<Vehicle> getVehicleByUser(String uname) {
		return repo.findByUser_Uname(uname);
	}
	
	public ApiResponse deleteVehicleByUser(String uname) {
		List<Vehicle> vehicles = getVehicleByUser(uname);
		repo.deleteAll(vehicles);
		return new ApiResponse("Vehicles successfully deleted for user : " + uname);
	}
	
}

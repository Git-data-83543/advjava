package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.entity.User;
import com.app.repository.UserRepo;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public User getUser(String uname) {
		return repo.findByUname(uname);
	}
	
	public User addUser(User user) {
		return repo.save(user);
	}
	
	public ApiResponse deleteUser(User user) {
		repo.delete(user);
		return new ApiResponse("User deleted Successfully");
	}
}

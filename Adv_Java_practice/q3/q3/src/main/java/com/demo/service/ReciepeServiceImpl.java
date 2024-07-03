package com.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.customExceptions.ResourceNotFoundException;
import com.demo.dtos.ApiResponse;
import com.demo.entities.Reciepe;
import com.demo.repository.ReciepeRepo;

@Service
@Transactional
public class ReciepeServiceImpl implements ReciepeService{

	@Autowired
	private ReciepeRepo repo;
	
	@Override
	public Reciepe getReciepeById(Long id) {
		return repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Invalid id!!"));
	}

	@Override
	public ApiResponse addReciepe(Reciepe reciepe) {
		repo.save(reciepe);
		return new ApiResponse("Reciepe is inserted!");
	}

	@Override
	public ApiResponse updateReciepe(Long id, Reciepe reciepe) {
		repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Invalid id!!"));
		repo.save(reciepe);
		return new ApiResponse("Reciepe is updated with ID => "+id+" !!!!");
	}

	@Override
	public ApiResponse deleteReciepe(Long id) {
		repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Invalid id!!"));
		repo.deleteById(id);;
		return new ApiResponse("Reciepe is deleted with ID => "+id+" !!");
	}

}

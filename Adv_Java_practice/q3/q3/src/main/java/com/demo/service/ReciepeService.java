package com.demo.service;

import com.demo.dtos.ApiResponse;
import com.demo.entities.Reciepe;

public interface ReciepeService {
	
	Reciepe getReciepeById(Long id);
	
	ApiResponse addReciepe(Reciepe reciepe);
	
	ApiResponse updateReciepe(Long id, Reciepe reciepe);
	
	ApiResponse deleteReciepe(Long id);
	
	
}

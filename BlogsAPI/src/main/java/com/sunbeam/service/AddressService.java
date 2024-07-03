package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AddressDTO;

public interface AddressService {
    
	ApiResponse assignAddressToUser(AddressDTO addressDto);

	List<AddressDTO> allAddress();
}

package com.sunbeam.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.dao.AddressDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.UserCityDTO;
import com.sunbeam.dto.AddressDTO;
import com.sunbeam.entities.Address;
import com.sunbeam.entities.User;

@Service
@Transactional
public class AddressServiceImpi implements AddressService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ApiResponse assignAddressToUser(AddressDTO addressDto) {
		 
		User user = userDao.findById(addressDto.getUserId())
				.orElseThrow(()-> new ApiException("User not existed !!"));
		  Address address = mapper.map(addressDto, Address.class);
		     Address address1 = addressDao.save(address);
		  user.setUserAddress(address1);
		return new ApiResponse("Address was Assigned !!"+userDao.save(user));
	}

	@Override
	public List<AddressDTO> allAddress() {
		return addressDao.findAll().stream()
				  .map(address -> mapper.map(address, AddressDTO.class))
		          .collect(Collectors.toList());
	}

}

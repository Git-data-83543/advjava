package com.sunbeam.service;


import java.util.List;

import com.sunbeam.dto.AdhaarCardAndLanguagesDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.UserCityDTO;
import com.sunbeam.dto.UserReqDTO;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.User;

public interface UserService {
	
	UserRespDTO authenticateUser(AuthRequest dto);

	User addUser(UserReqDTO request);

	List<UserRespDTO> allUser();

	List<UserCityDTO> allUserByCity(String city);

	ApiResponse asignAdhaarCardAndLanguages(AdhaarCardAndLanguagesDTO request);
}

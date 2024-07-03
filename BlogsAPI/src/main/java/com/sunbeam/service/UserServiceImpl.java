package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.custom_exceptions.AuthenticationException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.AdhaarCardAndLanguagesDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.CategoryDTO;
import com.sunbeam.dto.UserCityDTO;
import com.sunbeam.dto.UserReqDTO;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.User;
import com.sunbeam.value_types.AdhaarCard;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	// depcy
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserRespDTO authenticateUser(AuthRequest dto) {
		// 1.invoke dao 's method
		User user = userDao.findByEmailAndPassword(
				dto.getEmail(), dto.getPwd())
				.orElseThrow(() -> 
				new AuthenticationException("Invalid Email or Password !!!!!!"));
		//valid login -user : persistent -> entity -> dto
		return mapper.map(user, UserRespDTO.class);
	}

	@Override
	public User addUser(UserReqDTO request) {
		return userDao.save(mapper.map(request, User.class));
	}

	@Override
	public List<UserRespDTO> allUser() {
		
		return userDao.findAll().stream()
				  .map(user -> mapper.map(user, UserRespDTO.class))
		          .collect(Collectors.toList());
	}

	@Override
	public List<UserCityDTO> allUserByCity(String city) {
		List<User> users = userDao.findAllByUserAddressCity(city).orElseThrow(()->new ApiException("Not Found !!"));
		return users.stream()
				  .map(user -> mapper.map(user, UserCityDTO.class))
		          .collect(Collectors.toList());
	}

	@Override
	public ApiResponse asignAdhaarCardAndLanguages(AdhaarCardAndLanguagesDTO request) {
		   User user = userDao.findById(request.getUserId()).orElseThrow(()-> new ApiException("user is not found"));
		   user.setCard(new AdhaarCard(request.getCardNumber(), LocalDate.now(), request.getLocation()));
		   user.setLanguages(request.getLanguages());
		   return new ApiResponse("Assigned Language and Adhaar Card - "+userDao.save(user));
	}

}

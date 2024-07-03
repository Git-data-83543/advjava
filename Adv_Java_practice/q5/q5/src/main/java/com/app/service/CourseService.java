package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.entity.Course;
import com.app.repository.CourseRepo;

@Service
@Transactional
public class CourseService {
	
	@Autowired
	private CourseRepo repo;
	
	public Course getCourse(String cname) {
		return repo.findByCname(cname);
	}
	
	public Course addCourse(Course course) {
		return repo.save(course);
	}
	
	public ApiResponse deleteCourse(Course course) {
		repo.delete(course);
		return new ApiResponse("User deleted Successfully");
	}
}

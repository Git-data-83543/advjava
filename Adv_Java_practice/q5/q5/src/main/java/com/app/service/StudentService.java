package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.entity.Course;
import com.app.entity.Student;
import com.app.repository.CourseRepo;
import com.app.repository.StudentRepo;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private CourseRepo courserepo;
	
	public Student addStudent(Student student) {
		Course course = courserepo.findByCname(student.getCourse().getCname());
		student.setCourse(course);
		return repo.save(student);
	}
	
	public List<Student> getStudentByCourse(String cname) {
		return repo.findByCourse_Cname(cname);
	}
	
	public ApiResponse deleteStudentByCourse(String cname) {
		List<Student> students = getStudentByCourse(cname);
		repo.deleteAll(students);
		return new ApiResponse("Student successfully deleted for course : " + cname);
	}
	
}

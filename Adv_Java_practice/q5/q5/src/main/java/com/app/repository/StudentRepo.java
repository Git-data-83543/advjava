package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	List<Student> findByCourse_Cname(String cname);
}

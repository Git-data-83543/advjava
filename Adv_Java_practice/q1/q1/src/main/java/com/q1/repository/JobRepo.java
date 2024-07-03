package com.q1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.q1.entities.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Long> {

}

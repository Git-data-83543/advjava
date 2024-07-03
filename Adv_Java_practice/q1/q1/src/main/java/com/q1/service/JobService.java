package com.q1.service;

import java.util.List;

import com.q1.dtos.ApiResponse;
import com.q1.entities.Job;

public interface JobService {
	
	List<Job> getAllJobs();
	
	Job addNewJob(Job job);
	
	ApiResponse updateJob(Long id, Job job);
	
	ApiResponse deleteJob(Long id);
	
}

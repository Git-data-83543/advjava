package com.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.q1.custom_exceptions.ResourceNotFoundException;
import com.q1.dtos.ApiResponse;
import com.q1.entities.Job;
import com.q1.repository.JobRepo;

@Service
@Transactional
public class JobServiceImpl implements JobService{

	@Autowired
	private JobRepo repo;
	
	@Override
	public List<Job> getAllJobs() {
		return repo.findAll();
	}

	@Override
	public Job addNewJob(Job job) {
		return repo.save(job);
	}

	@Override
	public ApiResponse updateJob(Long id, Job job) {
		repo.findById(id).orElseThrow(()->
				new ResourceNotFoundException("Job not found!!!"));
		repo.save(job);
		return new ApiResponse("Job successfully updated");
	}

	@Override
	public ApiResponse deleteJob(Long id) {
		repo.findById(id).orElseThrow(()->
				new ResourceNotFoundException("Job not found!!!"));
		repo.deleteById(id);
		return new ApiResponse("Job with " + id + " is deleted successfully");
	}

}

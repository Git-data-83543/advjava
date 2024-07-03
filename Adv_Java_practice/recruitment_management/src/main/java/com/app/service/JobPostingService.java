package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.JobPostingDto;
import com.app.entity.JobPosting;

public interface JobPostingService {
	
	List<JobPostingDto> getAllJobPosts();
	JobPostingDto addNewJobPosting(JobPostingDto jp);
	ApiResponse updateNewJobPosting(Long id,JobPosting jp);
	ApiResponse deleteJobPosting(Long id);
	
	JobPostingDto getJobDetails(Long id);
	
	List<JobPostingDto> getJobDetailsByJobTitle(String title);

}

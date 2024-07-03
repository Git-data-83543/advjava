package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exc.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.JobPostingDto;
import com.app.entity.JobPosting;
import com.app.repository.JobPostingRepository;


@Service
@Transactional
public class JobPostingSeviceImpl implements JobPostingService{
		
	@Autowired
	private JobPostingRepository jp;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<JobPostingDto> getAllJobPosts()
	{
		return jp.findAll()
				.stream()
				.map(obj -> mapper.map(obj, JobPostingDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public JobPostingDto addNewJobPosting(JobPostingDto jpd)
	{
		JobPosting obj = mapper.map(jpd, JobPosting.class);
		JobPosting obj2 = jp.save(obj);
		
		return mapper.map(obj2, JobPostingDto.class);
		
	}
	
	@Override
	public ApiResponse updateNewJobPosting(Long id,JobPosting jpobj)
	{
		String msg="updation failed!!!";
		if(jp.existsById(id))
		{
			jp.save(jpobj);
			msg="jobposting updated successfully";
		}
		else {
			throw new ResourceNotFoundException("Inavalid id!!");
		}
		
		return new ApiResponse(msg);
	}
	
	@Override
	public ApiResponse deleteJobPosting(Long id)
	{
		String msg="invalid id!!!";
		if(jp.existsById(id))
		{
			jp.deleteById(id);
		    msg= "Post deleted successfully";
		}
		return  new ApiResponse(msg);
	}
	
	@Override
	public JobPostingDto getJobDetails(Long id)
	{
		Optional <JobPosting> opt = jp.findById(id);
		
		return mapper.map(opt.orElseThrow(()->new ResourceNotFoundException("Invalid id!!!")), JobPostingDto.class);
	}
	
	@Override
	public List<JobPostingDto> getJobDetailsByJobTitle(String title){
		
		List<JobPosting> list= jp.findByJobTitle(title);
		return 
				list.stream()
				.map(obj->mapper.map(obj, JobPostingDto.class))
				.collect(Collectors.toList());
		
	}

}

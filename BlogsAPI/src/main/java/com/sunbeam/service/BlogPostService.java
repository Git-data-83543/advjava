package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BlogGetResDTO;
import com.sunbeam.dto.BlogPostReqDTO;
import com.sunbeam.dto.TagAndPostDto;
import com.sunbeam.dto.TagAndPostDto2;

public interface BlogPostService {
	ApiResponse postNewBlog(BlogPostReqDTO requestDTO);

	List<BlogGetResDTO> getAllPost();

	ApiResponse addTagAndPost(TagAndPostDto dto);

	ApiResponse deleteTagAndPost(TagAndPostDto2 dto);
}

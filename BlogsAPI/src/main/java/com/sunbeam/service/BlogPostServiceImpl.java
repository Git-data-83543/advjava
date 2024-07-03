package com.sunbeam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.TagDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BlogGetResDTO;
import com.sunbeam.dto.BlogPostReqDTO;
import com.sunbeam.dto.TagAndPostDto;
import com.sunbeam.dto.TagAndPostDto2;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Tag;
import com.sunbeam.entities.User;

@Service
@Transactional
public class BlogPostServiceImpl implements BlogPostService {
	// depcy
	@Autowired
	private BlogPostDao blogPostDao;
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private UserDao userDao;
   
	@Autowired
	private TagDao tagDao;
	@Override
	public ApiResponse postNewBlog(BlogPostReqDTO requestDTO) {
		// 1. get category from it's id
		Category category = categoryDao.findById(requestDTO.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid category id !!!!"));
		// 2. get user(blogger) from it's id
		User blogger = userDao.findById(requestDTO.getAuthorId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid blogger id!!!"));
		// => category , blogger - exists -PERSISTENT
		// 2.5 map dto -> entity
		BlogPost blogPost = modelMapper.map(requestDTO, BlogPost.class);
		// 3. category 1<--->* post
		category.addBlogPost(blogPost);
		// 4. blogger 1<---* post
		blogPost.setBlogger(blogger);
		// 5. save blog post
		BlogPost periststentBlog = blogPostDao.save(blogPost);
		return new ApiResponse("New Blog added with ID=" + periststentBlog.getId());
	}

	@Override
	public List<BlogGetResDTO> getAllPost() {
		
		return blogPostDao.findAll().stream().map((blog)-> modelMapper.map(blog, BlogGetResDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse addTagAndPost(TagAndPostDto dto) {
		 
		BlogPost post = blogPostDao.findByTitle(dto.getTitle()).orElseThrow(()-> new ApiException("BlogPost is not Existed !!"));
		 Tag tag = tagDao.findByName(dto.getName()).orElseThrow(()-> new ApiException("Tag is not Existed !!"));
		   
		 tag.getPosts().add(post);
		 
		 return new ApiResponse("tag is added to the post !!!");
	}

	@Override
	public ApiResponse deleteTagAndPost(TagAndPostDto2 dto) {
		BlogPost post = blogPostDao.findById(dto.getPostId()).orElseThrow(()-> new ApiException("BlogPost is not Existed !!"));
		 Tag tag = tagDao.findById(dto.getTagId()).orElseThrow(()-> new ApiException("Tag is not Existed !!"));
		   
		 tag.getPosts().remove(post);
		 
		 return new ApiResponse("tag is delete from the post !!!");
	}

}

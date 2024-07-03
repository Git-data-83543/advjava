package com.sunbeam.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CommentDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentDto;
import com.sunbeam.dto.CommentPostDto;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Comment;
import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired 
    private BlogPostDao blogPostDao;
    
    @Autowired
    private ModelMapper mapper; 
    
	@Override
	public ApiResponse postComment(CommentPostDto commentDto) {
	    
	       User user = userDao.findById(commentDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not Exist !!!!"));
	
	       if(user.getRole() == Role.BLOGGER ) throw new ApiException("user is not COMMENTER !!");
	       BlogPost blogPost =  blogPostDao.findById(commentDto.getPostId()).orElseThrow(()-> new ResourceNotFoundException("Blog Post not Exist !!!!"));
	    
	       if(blogPost.getBlogger().getId() == user.getId()) throw new ApiException("you can't comment post on your own post !!");
	        
	      Comment comment = mapper.map(commentDto, Comment.class);  
	      
	      comment.setCommenter(user);
	      comment.setPost(blogPost);
	      
	      return new ApiResponse("Comment Added !! your Comment is - "+commentDao.save(comment));
	}

	@Override
	public ApiResponse putComment(CommentDto commentBody) {
		     Comment comment = commentDao.findById(commentBody.getId()).orElseThrow(()-> new ApiException("Not Found Comments"));
		     comment.setCommentText(commentBody.getCommentText());
		     comment.setRating(commentBody.getRating());
		     return new ApiResponse("Comment is Updated - "+commentDao.save(comment));
	}

	@Override
	public List<CommentDto> allComment() {
		return commentDao.findAll().stream()
				  .map(comment -> mapper.map(comment, CommentDto.class))
		          .collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteComment(Long userId) {
		 List<Comment> comment = commentDao.findAllByCommenterId(userId).orElseThrow(()-> new ApiException("comment not found of that user !!"));
		  commentDao.deleteAll(comment);
		
		  return new ApiResponse("deleted is done !!");
	}
	
}

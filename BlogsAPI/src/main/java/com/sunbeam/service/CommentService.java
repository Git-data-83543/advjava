package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentDto;
import com.sunbeam.dto.CommentPostDto;

public interface CommentService {

	ApiResponse putComment(CommentDto commentBody);

	List<CommentDto> allComment();

	ApiResponse deleteComment(Long userId);

	ApiResponse postComment(CommentPostDto commentDto);

}

package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentPostDto {
	private Long postId;
	private Long userId;
	private String commentText;
	private int rating;
}

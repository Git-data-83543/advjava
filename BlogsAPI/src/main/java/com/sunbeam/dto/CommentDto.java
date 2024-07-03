package com.sunbeam.dto;




import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto{
	private Long id;
	private String commentText;
	private int rating;
	@JsonProperty(access = Access.READ_ONLY)
	private BlogPostRespDTO post;
	@JsonProperty(access = Access.READ_ONLY)
	private UserRespDTO commenter;
}

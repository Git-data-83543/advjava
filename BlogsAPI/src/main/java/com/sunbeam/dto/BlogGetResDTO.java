package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogGetResDTO extends BaseDTO{
	private String title;
	private String description;
	private String content;
	private CategoryDTO selectedCategory;
	private UserRespDTO blogger;
}

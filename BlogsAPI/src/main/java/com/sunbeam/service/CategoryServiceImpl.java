package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CategoryDTO;
import com.sunbeam.dto.CategoryPostDTO;
import com.sunbeam.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	// depcy
	@Autowired
	private CategoryDao categoryDao;
	// depcy
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CategoryDTO> getAllCategories() {
		// ret all categories
		 List<CategoryDTO> categoryDTO =categoryDao.findAll().stream()
				  .map(category -> modelMapper.map(category, CategoryDTO.class))
		          .collect(Collectors.toList());	
		return categoryDTO;
	}

	@Override
	public Category addNewCategory(CategoryDTO category) {
		// save category details
		Category persistentCategory = categoryDao.save(modelMapper.map(category, Category.class));
		return persistentCategory;
	}

	@Override
	public CategoryDTO getCategoryDetails(Long categoryId) {
		// return category details
		Category categoryEnt = categoryDao.findById(categoryId) // Optional<Category>
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Category ID!!!!"));

		return modelMapper.map(categoryEnt, CategoryDTO.class);

	}

	@Override
	public ApiResponse updateCategoryDetails(Long categoryId, Category existingCategory) {
		String mesg = "Category Updation Failed : invalid id !!!!";
		// validate - chk if category exists !
		if (categoryDao.existsById(categoryId)) {
			categoryDao.save(existingCategory);
			mesg = "Updated category details";
		}
		return new ApiResponse(mesg);
	}// insert OR update

	@Override
	public ApiResponse deleteCategoryDetails(Long categoryId) {
		if (categoryDao.existsById(categoryId)) {
			categoryDao.deleteById(categoryId);
			return new ApiResponse("Delete category details !");
		}
		return new ApiResponse("Category Deletion failed");
	}

	@Override
	public CategoryPostDTO getCategoryAndPostDetails(Long categoryId) {
		// return category + posts details
		Category categoryEnt = categoryDao
				.getCategoryAndPosts(categoryId) // Optional<Category>
				.orElseThrow(
						() -> new ResourceNotFoundException("Invalid Category ID!!!!"));
		return modelMapper.map(categoryEnt,CategoryPostDTO.class);

	}

}

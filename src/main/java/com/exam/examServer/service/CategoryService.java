package com.exam.examServer.service;

import java.util.Set;

import com.exam.examServer.modals.exam.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Category getCategory(Long categoryId);
	public Set<Category> getCategories();
	public void deleteCategory(Long categoryId);
	

}

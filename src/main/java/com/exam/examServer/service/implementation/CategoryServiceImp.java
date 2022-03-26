package com.exam.examServer.service.implementation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examServer.modals.exam.Category;
import com.exam.examServer.repository.CategoryRepsoitory;
import com.exam.examServer.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	private CategoryRepsoitory categoryRepsoitory;

	@Override
	public Category addCategory(Category category) {
		
		return this.categoryRepsoitory.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return this.categoryRepsoitory.save(category);
	}

	@Override
	public Category getCategory(Long categoryId) {
		
		return this.categoryRepsoitory.findById(categoryId).get();
	}

	@Override
	public Set<Category> getCategories() {
		
		return new LinkedHashSet<Category>(this.categoryRepsoitory.findAll());
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category category=new Category();
		category.setCid(categoryId);
		this.categoryRepsoitory.delete(category);
		
	}

}

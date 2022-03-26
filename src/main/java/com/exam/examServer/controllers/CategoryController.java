package com.exam.examServer.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examServer.modals.exam.Category;
import com.exam.examServer.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/addcategory")
	public ResponseEntity<Category> addUser(@RequestBody Category category)
	{
		return ResponseEntity.ok(categoryService.addCategory(category));
	}
	
	@PutMapping("/updatecategory")
	public Category updateUser(@RequestBody Category category)
	{
		return categoryService.updateCategory(category);
	}
	
	@GetMapping("getcategory/{id}")
	public Category getCategory(@PathVariable("id") Long id)
	{
		return categoryService.getCategory(id);
	}
	
	@GetMapping("getcategories")
	public ResponseEntity<?> getCategoies()
	{
		return ResponseEntity.ok(categoryService.getCategories());
	}
	
	@DeleteMapping("deletecategory/{id}")
	public void deleteCategory(@PathVariable("id") Long id)
	{
		 categoryService.deleteCategory(id);
	}
}

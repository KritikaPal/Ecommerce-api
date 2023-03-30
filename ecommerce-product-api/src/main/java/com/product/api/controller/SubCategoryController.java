package com.product.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Product;
import com.product.api.entity.SubCategory;
import com.product.api.servce.SubCategoryService;

@RestController
@RequestMapping("/categories/{categoryId}/subcategories")
public class SubCategoryController {
	@Autowired
	private SubCategoryService subCategoryService;

	@PostMapping
	public ResponseEntity<SubCategory> createSubCategory(@RequestBody SubCategory subCategory,
			@PathVariable Long categoryId) {
		SubCategory savedSubCategory = subCategoryService.createSubCategory(subCategory, categoryId);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedSubCategory);
	}

	@GetMapping
	public ResponseEntity<List<SubCategory>> getSubCategoriesByCategoryId(@PathVariable Long categoryId) {
		List<SubCategory> subCategories = subCategoryService.getSubCategoriesByCategoryId(categoryId);
		return ResponseEntity.ok(subCategories);
	}

	@GetMapping("/{subCategoryId}/products")
	public ResponseEntity<List<Product>> getProductsBySubCategoryId(@PathVariable Long subCategoryId) {
		List<Product> products = subCategoryService.getProductsBySubCategoryId(subCategoryId);
		return ResponseEntity.ok(products);
	}
}

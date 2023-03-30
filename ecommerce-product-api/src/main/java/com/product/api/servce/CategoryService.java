package com.product.api.servce;

import java.util.List;

import com.product.api.entity.Category;

public interface CategoryService {
	Category createCategory(Category category);

	List<Category> getAllCategories();
}

package com.product.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.api.entity.Category;
import com.product.api.entity.Product;
import com.product.api.entity.SubCategory;
import com.product.api.repository.CategoryRepository;
import com.product.api.repository.SubCategoryRepository;
import com.product.api.servce.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public SubCategory createSubCategory(SubCategory subCategory, Long categoryId) {
		Category category = categoryRepository.getOne(categoryId);
		subCategory.setCategory(category);
		return subCategoryRepository.save(subCategory);
	}

	@Override
	public List<SubCategory> getSubCategoriesByCategoryId(Long categoryId) {
		Category category = categoryRepository.getOne(categoryId);
		return category.getSubCategories();
	}

	@Override
	public List<Product> getProductsBySubCategoryId(Long subCategoryId) {
		return subCategoryRepository.findBySubCategoryId(subCategoryId);

	}
}

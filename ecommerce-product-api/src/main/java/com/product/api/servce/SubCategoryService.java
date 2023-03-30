package com.product.api.servce;

import java.util.List;

import com.product.api.entity.Product;
import com.product.api.entity.SubCategory;

public interface SubCategoryService {
	SubCategory createSubCategory(SubCategory subCategory, Long categoryId);

	List<SubCategory> getSubCategoriesByCategoryId(Long categoryId);

	List<Product> getProductsBySubCategoryId(Long subCategoryId);
}

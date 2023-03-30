package com.product.api.servce;

import com.product.api.entity.Product;

public interface ProductService {
	Product createProduct(Product product, Long subCategoryId);

	Product getProductById(Long id);
}

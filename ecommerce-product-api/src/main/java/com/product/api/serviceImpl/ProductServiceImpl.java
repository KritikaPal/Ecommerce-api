package com.product.api.serviceImpl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.api.entity.Product;
import com.product.api.entity.SubCategory;
import com.product.api.repository.ProductRepository;
import com.product.api.repository.SubCategoryRepository;
import com.product.api.servce.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Override
	public Product createProduct(Product product, Long subCategoryId) {
		SubCategory subCategory = subCategoryRepository.getOne(subCategoryId);
		product.setSubCategory(subCategory);
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found"));
	}
}

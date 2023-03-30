package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.api.entity.Product;
import com.product.api.entity.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<Product> findBySubCategoryId(Long subCategoryId);
}


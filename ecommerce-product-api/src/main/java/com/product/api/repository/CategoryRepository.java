package com.product.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.api.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}


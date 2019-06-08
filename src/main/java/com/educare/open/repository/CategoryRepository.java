package com.educare.open.repository;

import com.educare.open.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
  List<Category> findAll();
}

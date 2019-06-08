package com.educare.open.service.impl;

import com.educare.open.model.Category;
import com.educare.open.repository.CategoryRepository;
import com.educare.open.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

}

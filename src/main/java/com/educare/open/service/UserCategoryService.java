package com.educare.open.service;

import com.educare.open.model.Category;
import com.educare.open.model.User;
import com.educare.open.model.UserCategory;


import java.util.Map;

public interface UserCategoryService {
  Map<Integer,Boolean> findAllReadCategoryByUserId(Integer userId);
  void save(User user, Category category, Boolean isRead);
}

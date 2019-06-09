package com.educare.open.service.impl;

import com.educare.open.model.Category;
import com.educare.open.model.User;
import com.educare.open.model.UserCategory;
import com.educare.open.repository.UserCategoryRepository;
import com.educare.open.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCategoryServiceImpl implements UserCategoryService {

  @Autowired
  UserCategoryRepository userCategoryRepository;

  @Override
  public Map<Integer, Boolean> findAllReadCategoryByUserId(Integer userId) {
    List<UserCategory> userCategories = userCategoryRepository.findAllByUserId(userId);
    Map<Integer, Boolean> readCategory = new HashMap<>();
    for (UserCategory userCategory: userCategories) {
      if (userCategory.getRead()) readCategory.put(userCategory.getCategory().getId(),userCategory.getRead());
    }
    return readCategory;
  }

  @Override
  public void save(User user, Category category, Boolean isRead) {
    userCategoryRepository.save(new UserCategory(user,category,isRead));
  }
}

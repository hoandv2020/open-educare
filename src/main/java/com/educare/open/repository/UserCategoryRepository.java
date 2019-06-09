package com.educare.open.repository;
import com.educare.open.model.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCategoryRepository extends JpaRepository<UserCategory,Integer> {
  List<UserCategory> findAllByUserId(Integer userId);
}

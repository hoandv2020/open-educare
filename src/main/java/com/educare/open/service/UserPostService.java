package com.educare.open.service;

import com.educare.open.model.User;
import com.educare.open.model.UserPost;

public interface UserPostService {
  UserPost getByUserIdAndPostId(Integer userId, Integer postId);
  void save(UserPost userPost);
}

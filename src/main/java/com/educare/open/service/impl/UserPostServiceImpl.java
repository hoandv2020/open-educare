package com.educare.open.service.impl;

import com.educare.open.model.User;
import com.educare.open.model.UserPost;
import com.educare.open.repository.PostRepository;
import com.educare.open.repository.UserPostRepository;
import com.educare.open.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserPostServiceImpl implements UserPostService {
  @Autowired
  private UserPostRepository userPostRepository;

  @Override
  public UserPost getByUserIdAndPostId(Integer userId, Integer postId) {
    return userPostRepository.getByUserIdAndPostId(userId,postId);
  }

  @Override
  public void save(UserPost userPost) {
    userPostRepository.save(userPost);
  }

//  @Autowired
//  private PostRepository userPostRepository;
//  @Override
//  public void save(User user, Integer postId) {
//    UserPost userPost = new UserPost(true, user)
//    userPostRepository.save(userPost);
//  }
}

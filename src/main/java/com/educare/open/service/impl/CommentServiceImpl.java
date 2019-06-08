package com.educare.open.service.impl;

import com.educare.open.model.Comment;
import com.educare.open.repository.CommentRepository;
import com.educare.open.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements CommentService {
  @Autowired
  CommentRepository commentRepository;
  @Override
  public List<Comment> findAllByPostID(Integer postId) {
    return commentRepository.findAllByPostId(postId);
  }
}

package com.educare.open.service;

import com.educare.open.model.Comment;

import java.util.List;

public interface CommentService {
  List<Comment> findAllByPostID(Integer postId);
}

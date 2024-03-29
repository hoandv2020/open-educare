package com.educare.open.repository;

import com.educare.open.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
  List<Comment> findAllByPostId(Integer postId);
}

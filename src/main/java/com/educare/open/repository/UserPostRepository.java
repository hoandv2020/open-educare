package com.educare.open.repository;

import com.educare.open.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostRepository extends JpaRepository<UserPost, Integer> {
    UserPost getByUserIdAndPostId(Integer userId, Integer postId);
}

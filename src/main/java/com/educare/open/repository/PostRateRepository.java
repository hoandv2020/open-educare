package com.educare.open.repository;

import com.educare.open.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRateRepository extends JpaRepository<Post, Integer> {
}

package com.educare.open.repository;

import com.educare.open.model.Post;
import com.educare.open.model.PostRate;
import com.educare.open.utils.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRateRepository extends JpaRepository<PostRate, Integer> {
    List<PostRate> findAllByPostId(Integer postId);
}

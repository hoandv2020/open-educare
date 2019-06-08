package com.educare.open.service;

import com.educare.open.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<Post> findAllByOrderByIdDesc(Pageable pageable);

    Post findById(Integer id);

    void save(Post post);

    void deleteById(Integer id);

    Boolean isRead(Integer userId, Integer postId);

    Page<Post> searchByTitle(String search, Pageable pageable);
}

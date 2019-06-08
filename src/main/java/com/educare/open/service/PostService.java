package com.educare.open.service;

import com.educare.open.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpSession;

public interface PostService {
    Page<Post> findAllByOrderByIdDesc(Pageable pageable);

    Post findById(Integer id);

    void save(Post post, HttpSession session);

    void deleteById(Integer id);

    Boolean isRead(Integer userId, Integer postId);

    Page<Post> searchByTitle(String search, Pageable pageable);
}

package com.educare.open.service.impl;

import com.educare.open.model.Post;
import com.educare.open.repository.PostRepository;
import com.educare.open.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post findById(Integer id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }
}

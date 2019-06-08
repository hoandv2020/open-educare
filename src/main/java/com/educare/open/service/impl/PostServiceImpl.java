package com.educare.open.service.impl;

import com.educare.open.model.Post;
import com.educare.open.model.UserPost;
import com.educare.open.repository.PostRepository;
import com.educare.open.repository.UserPostRepository;
import com.educare.open.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.Date;

public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserPostRepository userPostRepository;

    @Override
    public Post findById(Integer id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void save(Post post) {
        Date date = new Date();
        post.setCreateAt(new Timestamp(date.getTime()));
        postRepository.save(post);
    }

    @Override
    public Boolean isRead(Integer userId, Integer postId) {
        UserPost userPost = userPostRepository.getByUserIdAndPostId(userId, postId);
        if (userPost == null || !userPost.getRead()) {
            return false;
        }
        return true;
    }

    @Override
    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    public Page<Post> findAllByOrderByIdDesc(Pageable pageable) {
        return postRepository.findAllByOrderByIdDesc(pageable);
    }
}

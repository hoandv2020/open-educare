package com.educare.open.service.impl;

import com.educare.open.model.Post;
import com.educare.open.model.PostRate;
import com.educare.open.model.User;
import com.educare.open.repository.PostRateRepository;
import com.educare.open.repository.PostRepository;
import com.educare.open.service.PostRateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostRateServiceImpl implements PostRateService {
    @Autowired
    PostRateRepository postRateRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public float avgRateByPostId(Integer postID) {
        List<PostRate> postRates = postRateRepository.findAllByPostId(postID);
        if (postRates.size() == 0) {
            return 0;
        }
        float sum = 0;
        for (PostRate postRate : postRates) {
            sum += postRate.getRate();
        }

        return sum / postRates.size();
    }

    @Override
    public void save(Integer postId, User user, Integer rate) {
        postRateRepository.save(new PostRate(rate, postRepository.findById(postId).get(), user));
    }
}

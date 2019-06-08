package com.educare.open.service.impl;

import com.educare.open.model.PostRate;
import com.educare.open.repository.PostRateRepository;
import com.educare.open.service.PostRateService;
import com.educare.open.utils.Rate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostRateServiceImpl implements PostRateService {
    @Autowired
    PostRateRepository postRateRepository;

    @Override
    public float avgRateByPostId(Integer postID) {
        List<PostRate> postRates = postRateRepository.findAllByPostId(postID);
        float avgRate = 0;
        float sum = 0;
        for (PostRate postRate : postRates) {
            sum += postRate.getRate();
        }

        return sum / postRates.size();
    }
}

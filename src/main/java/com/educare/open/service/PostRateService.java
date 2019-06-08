package com.educare.open.service;

import com.educare.open.model.PostRate;
import com.educare.open.utils.Rate;

import java.util.List;

public interface PostRateService {
    float avgRateByPostId(Integer postID);
}

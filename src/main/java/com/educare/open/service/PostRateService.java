package com.educare.open.service;

import com.educare.open.model.Post;
import com.educare.open.model.PostRate;
import com.educare.open.model.User;
import com.educare.open.utils.Rate;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface PostRateService {
    float avgRateByPostId(Integer postID);

    void save(Integer postId, User user, Integer rate);
}

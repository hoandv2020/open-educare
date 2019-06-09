package com.educare.open.controller;

import com.educare.open.model.User;
import com.educare.open.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ModelAndView index(@PageableDefault(value = 10) Pageable pageable, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("index", "posts", postService.findAllByOrderByIdDesc(pageable));
        User currentUser = (User)httpSession.getAttribute("currentUser");
        boolean isLogin = false;
        if (currentUser!=null) isLogin =true;
        modelAndView.addObject("isLogin",isLogin);
        return modelAndView;
    }

}

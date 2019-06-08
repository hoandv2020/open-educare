package com.educare.open.controller;

import com.educare.open.model.Post;
import com.educare.open.service.CategoryService;
import com.educare.open.service.PostRateService;
import com.educare.open.service.PostService;
import com.educare.open.utils.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostRateService postRateService;

    @GetMapping
    public ModelAndView findAllByOrderByIdDesc(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts", postService.findAllByOrderByIdDesc(pageable));

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/posts/create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("categories", categoryService.findAll());

        return modelAndView;
    }

    @PostMapping(value = {"/create", "update"})
    public String save(Post post) {
        postService.save(post);

        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) {
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("customer", postService.findById(id));

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("posts/viewPost");
        modelAndView.addObject("post", postService.findById(id));
        modelAndView.addObject("isRead", postService.isRead(null, id));
        modelAndView.addObject("rating", postRateService.avgRateByPostId(id));
        return modelAndView;
    }

}

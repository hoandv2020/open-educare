package com.educare.open.controller;

import com.educare.open.model.Post;
import com.educare.open.service.CategoryService;
import com.educare.open.service.PostRateService;
import com.educare.open.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
    public ModelAndView findAllByOrderByIdDesc(@PageableDefault(value = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts", postService.findAllByOrderByIdDesc(pageable));

        return modelAndView;
    }

    @GetMapping("/search/{s}")
    public ModelAndView search(@PathVariable("s") String search, @PageableDefault(value = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("posts", postService.searchByTitle(search, pageable));

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
    public String save(Post post, HttpSession session) {
        postService.save(post, session);

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

    @GetMapping("/category/{id}")
    public ModelAndView searchByCategory(@PathVariable("id") Integer id, @PageableDefault(value = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts", postService.searchByCategoryId(id, pageable));

        return modelAndView;
    }

}

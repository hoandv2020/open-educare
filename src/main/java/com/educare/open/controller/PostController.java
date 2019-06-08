package com.educare.open.controller;

import com.educare.open.model.Comment;
import com.educare.open.model.Post;
import com.educare.open.model.User;
import com.educare.open.service.CategoryService;
import com.educare.open.service.CommentService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostRateService postRateService;

    @Autowired
    CommentService commentService;
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
    public ModelAndView view(@PathVariable("id") Integer id,HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("posts/viewPost");
        List<Comment> comments = commentService.findAllByPostID(id);
        modelAndView.addObject("comments",comments);
        modelAndView.addObject("post", postService.findById(id));
        modelAndView.addObject("isRead", postService.isRead(((User)session.getAttribute("currentUser")).getId(), id));
        modelAndView.addObject("rating", postRateService.avgRateByPostId(id));
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }
    @PostMapping("/{id}/checkRead")
    public String checkRead(HttpSession session,@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){

        User currentUser = (User) session.getAttribute("currentUser");
        redirectAttributes.addFlashAttribute("isRead", postService.isRead(
          currentUser.getId(), id));
//        postRateService.save(currentUser, id);
        return "redirect:/post/"+id;
    }
}

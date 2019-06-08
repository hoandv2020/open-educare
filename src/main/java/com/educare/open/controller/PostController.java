package com.educare.open.controller;

import com.educare.open.model.Comment;
import com.educare.open.model.Post;
import com.educare.open.model.User;
import com.educare.open.model.UserPost;
import com.educare.open.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    UserPostService userPostService;

    @Autowired
    UserCategoryService userCategoryService;

    @GetMapping
    public ModelAndView findAllByOrderByIdDesc(@PageableDefault(value = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts", postService.findAllByOrderByIdDesc(pageable));

        return modelAndView;
    }

    @PostMapping
    public ModelAndView search(@RequestParam("search") String search, @PageableDefault(value = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
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
        User currentUser = (User) session.getAttribute("currentUser");
        boolean isLogin = false;
        if (currentUser!=null){
            modelAndView.addObject("isRead", postService.isRead(currentUser.getId(), id));
            isLogin = true;
        }
        modelAndView.addObject("isLogin", isLogin);
        modelAndView.addObject("rating", postRateService.avgRateByPostId(id));
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }
    @PostMapping("/{id}/checkRead")
    public String checkRead(HttpSession session,@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        User currentUser = (User) session.getAttribute("currentUser");
        UserPost userPost = userPostService.getByUserIdAndPostId(currentUser.getId(),id);
        userPost.setRead(true);
        userPostService.save(userPost);
        userCategoryService.save(currentUser,userPost.getPost().getCategory(),userPost.getRead());
        redirectAttributes.addFlashAttribute("isRead", postService.isRead(
          currentUser.getId(), id));
        return "redirect:/post/"+id;
    }
    @GetMapping("/category/{id}")
    public ModelAndView searchByCategory(@PathVariable("id") Integer id, @PageableDefault(value = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts", postService.searchByCategoryId(id, pageable));
        return modelAndView;
    }

    @PostMapping("/rate/{postId}")
    public ModelAndView rate(@PathVariable("postId") Integer postId, @RequestParam("rate") Integer rate, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("redirect:/post/" + postId);
        User currentUser = (User) session.getAttribute("currentUser");
        postRateService.save(postId, currentUser, rate);
        return modelAndView;
    }

}

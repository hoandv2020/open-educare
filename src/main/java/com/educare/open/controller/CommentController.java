package com.educare.open.controller;

import com.educare.open.model.Comment;
import com.educare.open.model.User;
import com.educare.open.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
  @Autowired
  CommentService commentService;
  @GetMapping("/{postId}")
  public ModelAndView listComments(@PathVariable Integer postId, HttpSession httpSession){
    ModelAndView modelAndView = new ModelAndView("testListComment");
    List<Comment> comments = commentService.findAllByPostID(postId);
    modelAndView.addObject("comments",comments);
    User currentUser = (User)httpSession.getAttribute("currentUser");
    boolean isLogin = false;
    if (currentUser!=null) isLogin =true;
    modelAndView.addObject("isLogin",isLogin);
    return modelAndView;
  }
}

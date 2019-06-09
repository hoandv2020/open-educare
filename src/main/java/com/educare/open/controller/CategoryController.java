package com.educare.open.controller;

import com.educare.open.model.Category;
import com.educare.open.model.User;
import com.educare.open.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  CategoryService categoryService;
  @GetMapping
  public ModelAndView listCategories(HttpSession httpSession){
    ModelAndView modelAndView = new ModelAndView("testListCategories");
    List<Category> categories = categoryService.findAll();
    modelAndView.addObject("categories",categories);
    User currentUser = (User)httpSession.getAttribute("currentUser");
    boolean isLogin = false;
    if (currentUser!=null) isLogin =true;
    modelAndView.addObject("isLogin",isLogin);
    return modelAndView;
  }
}

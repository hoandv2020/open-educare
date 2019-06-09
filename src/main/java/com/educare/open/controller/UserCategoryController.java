package com.educare.open.controller;

import com.educare.open.model.User;
import com.educare.open.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/studyProgress")
public class UserCategoryController {
  @Autowired
  UserCategoryService userCategoryService;
  @GetMapping()
  public ModelAndView studyTree(HttpSession httpSession){
    ModelAndView modelAndView = new ModelAndView("studyProgress");
    Map<Integer,Boolean> readCategories = userCategoryService.findAllReadCategoryByUserId(((User)httpSession.getAttribute("currentUser")).getId());
    modelAndView.addObject("readCategories",readCategories);
    return modelAndView ;
  }
}

package com.educare.open.controller;

import com.educare.open.model.User;
import com.educare.open.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login(HttpSession session) {
        if (session.getAttribute("currentUser") != null) {
            return new ModelAndView("index");
        }
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("login");
        User user = userService.findByUsername(username);
        boolean isSuccess = false;
        if (user != null) {
            if (user.getPassword().equals(password)) {
                session.setAttribute("currentUser", user);
                isSuccess = true;
                modelAndView.setViewName("index");
            }
        }

        modelAndView.addObject("isSuccess", isSuccess);

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("index");
        session.removeAttribute("currentUser");

        return modelAndView;
    }
}

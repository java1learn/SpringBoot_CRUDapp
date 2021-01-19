package com.example.SpringBoot_CRUDapp.controller;


import com.example.SpringBoot_CRUDapp.model.User;
import com.example.SpringBoot_CRUDapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping("/user")
    public String getUserPage(){
        return "user";
    }


//    private UserRepository userRepository;
//
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping(value = "/")
//    public String printWelcome(Model model){
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello!");
//        messages.add("I'm Spring MVC-SECURITY application");
//        messages.add("5.2.0 version by sep'19 ");
//        model.addAttribute("messages", messages);
//        return "hello";
//    }

    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }
//
//    @GetMapping(value = "/user")
//    public String getUserInfo(Model model){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        model.addAttribute("mail", user.getMail());
//        model.addAttribute("id", user.getId());
//        model.addAttribute("password", user.getPassword());
//        model.addAttribute("lastName",user.getLastName());
//        model.addAttribute("department",user.getDepartment());
//        model.addAttribute("login", user.getUsername());
//        model.addAttribute("roles", user.getRoles());
//        return "user";
//    }



}

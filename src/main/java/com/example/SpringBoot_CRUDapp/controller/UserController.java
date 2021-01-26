package com.example.SpringBoot_CRUDapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }

}

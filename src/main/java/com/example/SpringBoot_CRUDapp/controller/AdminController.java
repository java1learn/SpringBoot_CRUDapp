package com.example.SpringBoot_CRUDapp.controller;

import com.example.SpringBoot_CRUDapp.model.User;
import com.example.SpringBoot_CRUDapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
  
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String printUser(Model model){
        List<User> userList = (List<User>) userService.getAllUsers();
        model.addAttribute("users",userList);
        return "users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "addUser";
    }

    @PostMapping("admin/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.createUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.deleteUser(user);
        return "redirect:/admin";
    }
}

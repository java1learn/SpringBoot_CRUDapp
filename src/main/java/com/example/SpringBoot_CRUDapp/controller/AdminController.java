package com.example.SpringBoot_CRUDapp.controller;

import com.example.SpringBoot_CRUDapp.model.User;
import com.example.SpringBoot_CRUDapp.service.RoleService;
import com.example.SpringBoot_CRUDapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String getAdmin(){
        return "users";
    }

//    private final UserService userService;
//    private final RoleService roleService;
//
//    @Autowired
//    public AdminController(UserService userService,
//                           RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @GetMapping("")
//    public String printUser(Model model) {
//        List<User> userList = (List<User>) userService.getAllUsers();
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        model.addAttribute("autorize", user);
//        model.addAttribute("login", user.getLogin());
//        model.addAttribute("newUser", new User());
//        model.addAttribute("roles", user.getRoles());
//        model.addAttribute("users", userList);
//        model.addAttribute("allRoles", roleService.getAllRoles());
//        return "users";
//    }
//
//
//    @PostMapping("/addUser")
//    public String addUser(@ModelAttribute User newUser) {
//        userService.createUser(newUser);
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/edit")
//    public String editUser(@ModelAttribute User editUser) {
//        userService.updateUser(editUser);
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id) {
//        User user = userService.getUserById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        userService.deleteUser(user);
//        return "redirect:/admin";
//    }

}

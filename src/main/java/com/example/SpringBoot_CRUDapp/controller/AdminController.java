package com.example.SpringBoot_CRUDapp.controller;

import com.example.SpringBoot_CRUDapp.model.Role;
import com.example.SpringBoot_CRUDapp.model.User;
import com.example.SpringBoot_CRUDapp.repository.RoleRepository;
import com.example.SpringBoot_CRUDapp.repository.UserRepository;
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

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AdminController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("")
    public String printUser(Model model) {
        List<User> userList = (List<User>) userRepository.findAll();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        model.addAttribute("login", user.getLogin());
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("users", userList);
        model.addAttribute("allRoles", roleRepository.findAll());
        return "users";
    }

//    @GetMapping("/addUser")
//    public String addUser(@RequestParam(value = "role", required = true) Role role, Model model){
//        User user = new User();
//        model.addAttribute("user",user);
//        return "addUser";
//    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User newUser) {
        userRepository.save(newUser);
        return "redirect:/admin";
    }

//    @GetMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") long id, Model model){
//        model.addAttribute("user",userRepository.findById(id));
//        return "editUser";
//    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User editUser) {
        userRepository.save(editUser);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/admin";
    }
}

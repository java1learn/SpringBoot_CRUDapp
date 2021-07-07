package com.example.SpringBoot_CRUDapp.controller;

import com.example.SpringBoot_CRUDapp.service.RoleService;
import com.example.SpringBoot_CRUDapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/newpage")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService,
                           RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String printUser(Model model, Principal principal) {
        model.addAttribute("autUser", userService.findUserByLogin(principal.getName()));
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "newpage";
    }


}

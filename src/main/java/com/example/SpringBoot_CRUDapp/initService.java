package com.example.SpringBoot_CRUDapp;


import com.example.SpringBoot_CRUDapp.model.Role;
import com.example.SpringBoot_CRUDapp.model.User;
import com.example.SpringBoot_CRUDapp.service.RoleService;
import com.example.SpringBoot_CRUDapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class initService {

    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public initService(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    void init() {
        initRoles();
        initUsers();
    }


    private void initRoles() {
        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_SUPPORT"));
        roleService.save(new Role("ROLE_MANAGER"));
        roleService.save(new Role("ROLE_USER"));
    }

    private void initUsers() {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleById(1L));

        userService.createUser(new User(
                "admin",
                "testAdminUser",
                "IT",
                "admin@admin.com",
                "admin",
                roles
        ));
    }
}

package com.example.SpringBoot_CRUDapp.rest;

import com.example.SpringBoot_CRUDapp.model.Role;
import com.example.SpringBoot_CRUDapp.model.User;
import com.example.SpringBoot_CRUDapp.service.RoleService;
import com.example.SpringBoot_CRUDapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/rest")
public class RestAdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public RestAdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/getAuthorizeUser")
    public ResponseEntity<User> getAuthUser() {
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(authUser);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<Set<Role>> getAllRoles() {
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.userDeleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResponseEntity.ok().body(user);
    }

}

package com.example.SpringBoot_CRUDapp.service;

import com.example.SpringBoot_CRUDapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {
    void createUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);

    Optional<User> getUserById(Long id);

    Optional<User> findByLogin(String userName);

}

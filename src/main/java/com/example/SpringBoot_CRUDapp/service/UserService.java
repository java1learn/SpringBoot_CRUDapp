package com.example.SpringBoot_CRUDapp.service;

import com.example.SpringBoot_CRUDapp.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    void userDeleteById(Long id);

    void createUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);

    Optional<User> getUserById(Long id);

    User findUserByLogin(String login);

    User findByLogin(String userName);

}

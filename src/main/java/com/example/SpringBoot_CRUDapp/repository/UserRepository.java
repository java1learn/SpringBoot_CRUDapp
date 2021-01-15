package com.example.SpringBoot_CRUDapp.repository;

import com.example.SpringBoot_CRUDapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String userName);
}

package com.example.SpringBoot_CRUDapp.repository;

import com.example.SpringBoot_CRUDapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String userName);

    void deleteById(Long id);
}

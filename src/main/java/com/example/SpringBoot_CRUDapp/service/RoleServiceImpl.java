package com.example.SpringBoot_CRUDapp.service;

import com.example.SpringBoot_CRUDapp.model.Role;
import com.example.SpringBoot_CRUDapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Role> getAllRoles() {
        return (Set<Role>) repository.findAll();
    }

}

package com.example.SpringBoot_CRUDapp.service;

import com.example.SpringBoot_CRUDapp.model.Role;
import com.example.SpringBoot_CRUDapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> getAllRoles() {
        return (List<Role>) repository.findAll();
    }

}

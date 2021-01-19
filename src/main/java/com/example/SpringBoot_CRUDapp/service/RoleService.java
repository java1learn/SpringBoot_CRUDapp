package com.example.SpringBoot_CRUDapp.service;

import com.example.SpringBoot_CRUDapp.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles();

}

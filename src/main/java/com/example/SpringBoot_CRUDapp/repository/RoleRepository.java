package com.example.SpringBoot_CRUDapp.repository;

import com.example.SpringBoot_CRUDapp.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}

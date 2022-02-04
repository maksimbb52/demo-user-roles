package com.example.crudtoboot.service;

import com.example.crudtoboot.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<Role> indexRoles();
    Role findRoleByName(String roleName);
    Role findRoleById(Long id);
}

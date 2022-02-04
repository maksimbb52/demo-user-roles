package com.example.crudtoboot.dao;

import com.example.crudtoboot.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {

    List<Role> indexRoles();
    Role findRoleByName(String roleName);
    Role findRoleById(Long id);
}

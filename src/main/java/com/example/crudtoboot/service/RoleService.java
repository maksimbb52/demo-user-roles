package com.example.crudtoboot.service;

import com.example.crudtoboot.entity.RoleEntity;

import java.util.List;

public interface RoleService {

    List<RoleEntity> indexRoles();
    RoleEntity findRoleByName(String roleName);
    RoleEntity findRoleById(Long id);
}

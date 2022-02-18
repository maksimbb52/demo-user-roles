package com.example.crudtoboot.dao;

import com.example.crudtoboot.entity.RoleEntity;

import java.util.List;

public interface RoleDao {

    List<RoleEntity> indexRoles();
    RoleEntity findRoleByName(String roleName);
    RoleEntity findRoleById(Long id);
}

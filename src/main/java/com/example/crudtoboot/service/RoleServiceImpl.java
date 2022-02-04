package com.example.crudtoboot.service;

import com.example.crudtoboot.dao.RoleDao;
import com.example.crudtoboot.dao.RoleDaoImpl;
import com.example.crudtoboot.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleDaoImpl roleDao;

    @Transactional
    @Override
    public List<Role> indexRoles() {
        return roleDao.indexRoles();
    }

    @Transactional
    @Override
    public Role findRoleByName(String roleName) {
        return roleDao.findRoleByName(roleName);
    }

    @Transactional
    @Override
    public Role findRoleById(Long id) {
        return roleDao.findRoleById(id);
    }
}

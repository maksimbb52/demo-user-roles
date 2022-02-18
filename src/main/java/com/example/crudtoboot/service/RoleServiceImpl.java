package com.example.crudtoboot.service;

import com.example.crudtoboot.dao.RoleDaoImpl;
import com.example.crudtoboot.entity.RoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleDaoImpl roleDao;

    @Transactional
    @Override
    public List<RoleEntity> indexRoles() {
        return roleDao.indexRoles();
    }

    @Transactional
    @Override
    public RoleEntity findRoleByName(String roleName) {
        return roleDao.findRoleByName(roleName);
    }

    @Transactional
    @Override
    public RoleEntity findRoleById(Long id) {
        return roleDao.findRoleById(id);
    }
}

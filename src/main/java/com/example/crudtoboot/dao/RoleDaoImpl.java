package com.example.crudtoboot.dao;

import com.example.crudtoboot.entity.RoleEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RoleEntity> indexRoles() {
        Query query = entityManager.createQuery("from RoleEntity");
//        Set<Role> roles = new HashSet<Role>(query.getResultList());
        return query.getResultList();    }

    @Override
    public RoleEntity findRoleByName(String roleName) {
        TypedQuery<RoleEntity> query =  (TypedQuery<RoleEntity>) entityManager.createQuery("from RoleEntity where roleName = :roleName");
        query.setParameter("roleName", roleName);
        return query.getSingleResult();
    }

    @Override
    public RoleEntity findRoleById(Long id) {
        TypedQuery<RoleEntity> query =  (TypedQuery<RoleEntity>) entityManager.createQuery("from RoleEntity where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}

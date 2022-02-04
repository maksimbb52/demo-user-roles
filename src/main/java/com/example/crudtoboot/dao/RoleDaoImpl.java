package com.example.crudtoboot.dao;

import com.example.crudtoboot.models.Role;
import com.example.crudtoboot.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> indexRoles() {
        Query query = entityManager.createQuery("from Role");
//        Set<Role> roles = new HashSet<Role>(query.getResultList());
        return query.getResultList();    }

    @Override
    public Role findRoleByName(String roleName) {
        TypedQuery<Role> query =  (TypedQuery<Role>) entityManager.createQuery("from Role where roleName = :roleName");
        query.setParameter("roleName", roleName);
        return query.getSingleResult();
    }

    @Override
    public Role findRoleById(Long id) {
        TypedQuery<Role> query =  (TypedQuery<Role>) entityManager.createQuery("from Role where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}

package com.example.crudtoboot.dao;

import com.example.crudtoboot.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    //нужен ли тут EntityManager, в Spring Boot он ведь уже есть?
    private EntityManager entityManager;

    @Override
    public List<UserEntity> index() {
        Query query = entityManager.createQuery("from UserEntity");
        return query.getResultList();
    }

    @Override
    public void addUser(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE  from UserEntity where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public UserEntity show(Long id) {
        TypedQuery<UserEntity> query = (TypedQuery<UserEntity>) entityManager.createQuery("from UserEntity where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return entityManager.merge(userEntity);
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        TypedQuery<UserEntity> query = (TypedQuery<UserEntity>) entityManager.createQuery("from UserEntity where email = :email");
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}
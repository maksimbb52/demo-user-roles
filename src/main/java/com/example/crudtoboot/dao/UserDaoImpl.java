package com.example.crudtoboot.dao;

import com.example.crudtoboot.models.User;
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
    public List<User> index() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE  from User where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public User show(Long id) {
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("from User where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Long id, User updatedUser) {
        User userToBeUpdate = show(id);
        userToBeUpdate.setFirstName(updatedUser.getFirstName());
        userToBeUpdate.setLastName(updatedUser.getLastName());
        userToBeUpdate.setAge(updatedUser.getAge());
        userToBeUpdate.setEmail(updatedUser.getEmail());
        userToBeUpdate.setPassword(updatedUser.getPassword());
        entityManager.merge(userToBeUpdate);
    }

    @Override
    public User findUserByEmail(String email) {
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("from User where email = :email");
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}
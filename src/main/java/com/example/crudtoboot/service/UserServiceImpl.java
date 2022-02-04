package com.example.crudtoboot.service;

import com.example.crudtoboot.dao.UserDao;
import com.example.crudtoboot.models.Role;
import com.example.crudtoboot.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Transactional
    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        user.setRoles(Collections.singleton(new Role(2L, "ROLE_USER")));
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public User show(Long id) {
        return userDao.show(id);
    }

    @Transactional
    @Override
    public void update(Long id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Transactional
    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }
}
package com.example.crudtoboot.dao;

import com.example.crudtoboot.models.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    void addUser(User user);
    void delete(Long id);
    User show(Long id);
    void update(Long id, User updatedUser);
    User findUserByEmail(String email);
}

package com.example.crudtoboot.service;

import com.example.crudtoboot.models.User;

import java.util.List;

public interface UserService {
    List<User> index();
    void addUser(User user);
    void delete(Long id);
    User show(Long id);
    void update(Long id, User updatedUser);
    User findUserByEmail(String email);
}

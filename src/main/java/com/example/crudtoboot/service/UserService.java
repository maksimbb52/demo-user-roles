package com.example.crudtoboot.service;

import com.example.crudtoboot.dao.UserDao;
import com.example.crudtoboot.dto.UserDto;
import com.example.crudtoboot.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> index();
    void addUser(UserDto userDto);
    void delete(Long id);
    UserEntity show(Long id);
    void update(UserDto userDto);
    UserEntity findUserByEmail(String email);
}

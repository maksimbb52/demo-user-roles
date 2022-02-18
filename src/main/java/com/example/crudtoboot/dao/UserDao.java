package com.example.crudtoboot.dao;

import com.example.crudtoboot.entity.UserEntity;

import java.util.List;

public interface UserDao {
    List<UserEntity> index();
    void addUser(UserEntity userEntity);
    void delete(Long id);
    UserEntity show(Long id);
    UserEntity save(UserEntity updatedUserEntity);
    UserEntity findUserByEmail(String email);
}

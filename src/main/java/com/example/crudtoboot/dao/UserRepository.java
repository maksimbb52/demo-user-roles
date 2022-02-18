package com.example.crudtoboot.dao;

import com.example.crudtoboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends UserDao{
//public interface UserRepository extends JpaRepository<UserEntity, Long>, UserDao{

    UserEntity findUserByEmail(String email);
}

package com.example.crudtoboot.service;

import com.example.crudtoboot.dao.UserDao;
import com.example.crudtoboot.dto.UserDto;
import com.example.crudtoboot.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.crudtoboot.util.mapper.UserMapper.toEntity;
import static com.example.crudtoboot.util.mapper.UserMapper.toModel;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Transactional
    @Override
    public List<UserEntity> index() {
        return userDao.index();
    }

    @Transactional
    @Override
    public void addUser(UserDto userDto) {
        userDao.addUser(toEntity(toModel(userDto)));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public UserEntity show(Long id) {
        return userDao.show(id);
    }

    @Transactional
    @Override
    public void update(UserDto userDto) {
        userDao.save(toEntity(toModel(userDto)));
    }

    @Transactional
    @Override
    public UserEntity findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }
}
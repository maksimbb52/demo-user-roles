package com.example.crudtoboot.service;

import com.example.crudtoboot.dao.UserDao;
import com.example.crudtoboot.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.crudtoboot.util.mapper.UserMapper.toModel;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.findUserByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return toModel(userEntity);
    }
}

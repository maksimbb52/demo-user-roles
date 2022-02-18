package com.example.crudtoboot.util.mapper;

import com.example.crudtoboot.dto.UserDto;
import com.example.crudtoboot.entity.RoleEntity;
import com.example.crudtoboot.entity.UserEntity;
import com.example.crudtoboot.model.Role;
import com.example.crudtoboot.model.User;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public final class UserMapper {

    private UserMapper() {
    }

    public static User toModel(UserEntity entity){
        if (entity == null) {
            return null;
        }
        return User.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .age(entity.getAge())
                .roles(Optional.ofNullable(entity.getRoles())
                        .orElse(Collections.emptySet())
                        .stream()
                        .map(r -> Role.builder()
                                .id(r.getId())
                                .roleName(r.getRoleName())
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }
    public static User toModel(UserDto dto){
        if (dto == null) {
            return null;
        }
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .age(dto.getAge())
                .roles(Optional.ofNullable(dto.getRoles())
                        .orElse(Collections.emptySet())
                        .stream()
                        .map(r -> Role.builder()
                                .id(r.getId())
                                .roleName(r.getRoleName())
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }
    public static UserEntity toEntity(User user){
        if (user == null) {
            return null;
        }
        return UserEntity.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .age(user.getAge())
                .roles(Optional.ofNullable(user.getRoles())
                        .orElse(Collections.emptySet())
                        .stream()
                        .map(r -> RoleEntity.builder()
                                .id(r.getId())
                                .roleName(r.getRoleName())
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }
}

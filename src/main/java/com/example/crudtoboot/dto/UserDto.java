package com.example.crudtoboot.dto;

import com.example.crudtoboot.entity.RoleEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
public class UserDto{

    String firstName;

    String lastName;

    byte age;

    String email;

    String password;

    Set<RoleEntity> roles;
}
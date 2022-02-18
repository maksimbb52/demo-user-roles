package com.example.crudtoboot.model;

import com.example.crudtoboot.entity.RoleEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Value
@Builder
public class User implements UserDetails {

    Long id;

    String firstName;

    String lastName;

    byte age;

    String email;

    String password;

    @Singular
    Set<Role> roles;

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
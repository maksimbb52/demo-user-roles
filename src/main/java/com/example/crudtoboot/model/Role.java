package com.example.crudtoboot.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Value
@Builder
public class Role implements GrantedAuthority {

    Long id;

    String roleName;

    @Override
    public String toString() {
        return this.roleName;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
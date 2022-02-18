package com.example.crudtoboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "roles")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    private Long id;

    @Column
    private String roleName;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> userEntities;

}
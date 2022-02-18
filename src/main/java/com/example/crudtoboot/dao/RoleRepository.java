package com.example.crudtoboot.dao;

import com.example.crudtoboot.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long >, RoleDao{

//    @Query("SELECT r FROM Role r WHERE r.roleName = ?1")
     RoleEntity findByRoleName(String roleName);
}

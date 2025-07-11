package com.comanDaBack.comanDa.security.repository;

import com.comanDaBack.comanDa.security.entity.Role;
import com.comanDaBack.comanDa.security.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository< Role , Long> {
    Optional<Role> findByRoleEnum(RoleEnum roleEnum);

}

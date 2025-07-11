package com.comanDaBack.comanDa.security.repository;

import com.comanDaBack.comanDa.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUserEntityByUsername(String username);
    boolean existsByUsername(String username);
}

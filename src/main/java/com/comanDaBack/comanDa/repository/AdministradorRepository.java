package com.comanDaBack.comanDa.repository;

import com.comanDaBack.comanDa.entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador , Long> {

}

package com.comanDaBack.comanDa.repository;

import com.comanDaBack.comanDa.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa , Long> {
    boolean existsByNumMesa(int numMesa);
}

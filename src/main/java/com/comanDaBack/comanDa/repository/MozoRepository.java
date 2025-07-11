package com.comanDaBack.comanDa.repository;

import com.comanDaBack.comanDa.entity.Mozo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MozoRepository extends JpaRepository<Mozo, Long> {
}

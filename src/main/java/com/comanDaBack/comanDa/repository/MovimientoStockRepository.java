package com.comanDaBack.comanDa.repository;

import com.comanDaBack.comanDa.entity.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoStockRepository extends JpaRepository<MovimientoStock , Long> {
}

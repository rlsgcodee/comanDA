package com.comanDaBack.comanDa.repository;

import com.comanDaBack.comanDa.entity.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservacionRepository extends JpaRepository<Reservacion , Long> {
}

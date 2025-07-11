package com.comanDaBack.comanDa.repository;


import com.comanDaBack.comanDa.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido , Long> {
}

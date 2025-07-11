package com.comanDaBack.comanDa.repository;

import com.comanDaBack.comanDa.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente , Long> {
    List<Ingrediente> findByNombreIngredienteContainingIgnoreCase(String nombreIngrediente);
    boolean existsByNombreIngrediente(String nombreIngrediente);
}

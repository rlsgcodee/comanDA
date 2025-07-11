package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.IngredienteRequestDTO;
import com.comanDaBack.comanDa.dto.IngredienteResponseDTO;
import com.comanDaBack.comanDa.mapper.IngredienteResponseMapper;

import java.util.List;

public interface IngredienteService {
    List<IngredienteResponseDTO> listarIngredientes();

    IngredienteResponseDTO guardarIngrediente(IngredienteRequestDTO ingredienteRequestDTO);

    IngredienteResponseDTO modificarIngrediente(Long idIngrediente, IngredienteRequestDTO ingredienteRequestDTO);

    List<IngredienteResponseDTO> findByNombreIngrediente(String nombreIngrediente);

    void eliminarIngrediente(Long idIngrediente);
}

package com.comanDaBack.comanDa.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoriaIngreResponseDTO {
    private Long idCategoria;
    private String nombreCategoria;
    private List<IngredienteResponseDTO> ingredientes;
}

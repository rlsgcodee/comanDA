package com.comanDaBack.comanDa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoriaIngredienteDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idCategoria;
    private String nombreCatIngrediente;
}

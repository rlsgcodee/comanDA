package com.comanDaBack.comanDa.dto;


import com.comanDaBack.comanDa.entity.UnidadMedida;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;



@Data
public class IngredienteRequestDTO {
    private String nombreIngrediente;
    private int stockActual;
    @Schema(description = "Unidad de medida permitida",
            allowableValues = {"UNIDAD", "GRAMO", "KILOGRAMO", "LITRO", "MILILITRO"})
    private UnidadMedida unidadMedida;
    private Long idCategoria;
}

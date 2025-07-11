package com.comanDaBack.comanDa.dto;

import com.comanDaBack.comanDa.entity.UnidadMedida;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class IngredienteResponseDTO {
    private Long idIngrediente;
    private String nombreIngrediente;
    private LocalDateTime ultimaActualizacion;
    private int stockActual;
    private UnidadMedida unidadMedida;
    private String nombreCategoria;
}

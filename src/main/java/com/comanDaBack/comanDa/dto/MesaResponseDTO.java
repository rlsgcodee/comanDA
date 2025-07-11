package com.comanDaBack.comanDa.dto;

import com.comanDaBack.comanDa.entity.EstadoMesa;
import lombok.Data;

@Data
public class MesaResponseDTO {
    private int numMesa;
    private int capacidad;
    private EstadoMesa estadoMesa;
    private String nombreMozo;
}

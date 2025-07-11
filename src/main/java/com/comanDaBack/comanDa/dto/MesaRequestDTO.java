package com.comanDaBack.comanDa.dto;

import com.comanDaBack.comanDa.entity.EstadoMesa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MesaRequestDTO {
    private Long idMesa;
    private int numMesa;
    private int capacidad;
    private EstadoMesa estadoMesa;
    private Long  idMozo;
}

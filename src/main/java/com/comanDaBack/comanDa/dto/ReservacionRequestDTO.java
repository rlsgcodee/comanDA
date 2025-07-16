package com.comanDaBack.comanDa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservacionRequestDTO {
    private String nombreCliente;
    private String telefono;
    private int cantidadPersonas;
    private String descripcion;
    private Long idMesa;
}

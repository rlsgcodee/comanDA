package com.comanDaBack.comanDa.dto;

import com.comanDaBack.comanDa.entity.EstadoMesa;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservacionResponseDTO {
    private Long idReservacion;
    private String nombreReservacion;
    private String telefono;
    private int cantidadPersonas;
    private LocalDateTime fechaHora;
    private String descripcion;
    private EstadoMesa estadoMesa;
    private MesaResponseDTO numMesa;
}

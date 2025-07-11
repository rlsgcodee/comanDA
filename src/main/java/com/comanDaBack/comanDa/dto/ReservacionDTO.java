package com.comanDaBack.comanDa.dto;

import com.comanDaBack.comanDa.entity.EstadoMesa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservacionDTO {
    private Long idReservacion;
    private String nombreCliente;
    private String telefono;
    private int cantidadPersonas;
    private LocalDateTime fechaHora;
    private String descripcion;
    private EstadoMesa estadoMesa;
    private MesaRequestDTO mesa;
}

package com.comanDaBack.comanDa.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoMozoResponseDTO {
    private int numMesa;
    private String estadoPedido;
    private LocalDateTime fechaHora;
    private List<DetallePedidoMozoDTO> detalles;
    private double total;
}

package com.comanDaBack.comanDa.dto;

import lombok.Data;

import java.util.List;

@Data
public class PedidoAgregarProductosDTO {
    private Long idPedido;
    private List<DetallePedidoRequestDTO> detalles;
}

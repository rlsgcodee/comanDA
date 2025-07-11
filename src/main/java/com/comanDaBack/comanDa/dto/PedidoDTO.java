package com.comanDaBack.comanDa.dto;

import com.comanDaBack.comanDa.entity.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private Long idPedido;
    private LocalDateTime fechaHora;
    private double montoTotal;
    private EstadoPedido estadoPedido;
    private List<DetallePedidoDTO> pedidos;
    private MesaRequestDTO mesa;
    private MozoDTO mozo;
}

package com.comanDaBack.comanDa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoDTO {
    private Long idDetalle;
    private int cantidad;
    private MenuRequestDTO menu;
    private double subTotal;
}

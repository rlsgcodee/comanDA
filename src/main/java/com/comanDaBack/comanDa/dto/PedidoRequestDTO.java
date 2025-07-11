package com.comanDaBack.comanDa.dto;



import lombok.Data;


import java.util.List;

@Data
public class PedidoRequestDTO {
    private Long idMesa;
    private Long idMozo;
    private List<DetallePedidoRequestDTO> detalles;
}

package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.*;

import java.util.List;

public interface PedidoService {
    PedidoMozoResponseDTO guardarPedido(PedidoRequestDTO pedidoRequestDTO);

    PedidoMozoResponseDTO agregarProductosAlPedido(Long idPedido, List<DetallePedidoRequestDTO> nuevosProductos);

    List<PedidoMozoResponseDTO> listarPedidos();
}

package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.MovimientoStockRequestDTO;
import com.comanDaBack.comanDa.dto.MovimientoStockResponseDTO;
import java.util.List;


public interface MovimientoStockService {
    MovimientoStockResponseDTO guardarMovimientoStock(MovimientoStockRequestDTO movimientoStockRequestDTO);
    List<MovimientoStockResponseDTO> listarMovimientos();
}

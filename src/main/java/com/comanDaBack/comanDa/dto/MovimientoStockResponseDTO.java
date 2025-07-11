package com.comanDaBack.comanDa.dto;

import com.comanDaBack.comanDa.entity.TipoMovimiento;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovimientoStockResponseDTO {
    private int cantidad;
    private LocalDateTime fechaMovimiento;
    private TipoMovimiento tipoMovimiento;
    private String nombreIngrediente;
}

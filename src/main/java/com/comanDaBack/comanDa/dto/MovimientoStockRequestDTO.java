package com.comanDaBack.comanDa.dto;

import com.comanDaBack.comanDa.entity.TipoMovimiento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
public class MovimientoStockRequestDTO {

        private int cantidad;
        private LocalDateTime fechaMovimiento;
        private TipoMovimiento tipoMovimiento;
        private Long idIngrediente;
}

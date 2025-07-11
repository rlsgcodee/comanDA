package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.MovimientoStockResponseDTO;
import com.comanDaBack.comanDa.entity.MovimientoStock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimientoResponseMapper {

    @Mapping(source = "cantidad" , target="cantidad")
    @Mapping(source = "fechaMovimiento" , target="fechaMovimiento")
    @Mapping(source = "tipoMovimiento" , target = "tipoMovimiento")
    @Mapping(source = "ingrediente.nombreIngrediente" , target="nombreIngrediente")
    MovimientoStockResponseDTO toDTO(MovimientoStock movimientoStock);
}

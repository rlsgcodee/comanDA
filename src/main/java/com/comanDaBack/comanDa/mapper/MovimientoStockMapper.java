package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.MovimientoStockRequestDTO;
import com.comanDaBack.comanDa.entity.MovimientoStock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimientoStockMapper {


    @Mapping(target="idStock" , ignore = true)
    @Mapping(target="ingrediente" , ignore = true)
    MovimientoStock toEntity(MovimientoStockRequestDTO movimientoStockRequestDTO);
}

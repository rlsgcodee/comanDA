package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.MesaResponseDTO;
import com.comanDaBack.comanDa.entity.Mesa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MesaResponseMapper {

    @Mapping(source = "numMesa", target="numMesa")
    @Mapping(source = "capacidad" , target = "capacidad")
    @Mapping(source = "estadoMesa" , target = "estadoMesa")
    @Mapping(source = "mozo.nombreMozo" , target= "nombreMozo" )
    MesaResponseDTO toDTO(Mesa mesa);
}

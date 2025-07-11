package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.MesaRequestDTO;
import com.comanDaBack.comanDa.entity.Mesa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MesaRequestMapper {

    @Mapping(target="idMesa", ignore = true)
    @Mapping(target = "mozo" , ignore = true)
    Mesa toEntity(MesaRequestDTO mesaRequestDTO);

    void updateMesaFromDTO(MesaRequestDTO dto , @MappingTarget Mesa entity);
}

package com.comanDaBack.comanDa.mapper;


import com.comanDaBack.comanDa.dto.CategoriaMenuResponseDTO;
import com.comanDaBack.comanDa.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MenuResponseMapper.class})
public interface CategoriaMenuResponseMapper {

    CategoriaMenuResponseDTO toDTO(Categoria categoria);
}

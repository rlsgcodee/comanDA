package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.IngredienteRequestDTO;
import com.comanDaBack.comanDa.entity.Ingrediente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IngredienteRequestMapper {

    Ingrediente toIngrediente(IngredienteRequestDTO ingredienteRequestDTO);

    void updateIngredienteFromDTO(IngredienteRequestDTO dto, @MappingTarget Ingrediente ingrediente);

}

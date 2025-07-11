package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.CategoriaIngreResponseDTO;
import com.comanDaBack.comanDa.entity.Categoria;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring" , uses = {IngredienteResponseMapper.class})
public interface CategoriaIngResponseMapper {

    CategoriaIngreResponseDTO toDTO(Categoria categoria);

}

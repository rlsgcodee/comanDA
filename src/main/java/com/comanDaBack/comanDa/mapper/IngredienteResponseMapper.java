package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.IngredienteResponseDTO;
import com.comanDaBack.comanDa.entity.Ingrediente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IngredienteResponseMapper {
    @Mapping(source = "nombreIngrediente" , target = "nombreIngrediente")
    @Mapping(source = "ultimaActualizacion" , target= "ultimaActualizacion")
    @Mapping(source = "stockActual", target="stockActual")
    @Mapping(source = "unidadMedida" , target = "unidadMedida")
    @Mapping(source = "categoria.nombreCategoria", target = "nombreCategoria")
    IngredienteResponseDTO toDTO(Ingrediente ingrediente);
}

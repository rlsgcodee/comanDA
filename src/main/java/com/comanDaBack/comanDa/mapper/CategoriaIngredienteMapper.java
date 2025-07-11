package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.CategoriaIngredienteDTO;
import com.comanDaBack.comanDa.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" )
public interface CategoriaIngredienteMapper {
    @Mapping(source ="nombreCatIngrediente", target="nombreCategoria" )
    @Mapping(target = "menus" , ignore = true)
    @Mapping(target = "ingredientes" , ignore= true)
    Categoria toEntity(CategoriaIngredienteDTO categoriaIngredienteDTO);

    @Mapping(source ="nombreCategoria", target="nombreCatIngrediente" )
    @Mapping(source = "idCategoria" , target = "idCategoria")
    CategoriaIngredienteDTO   toDTO(Categoria categoria);

}

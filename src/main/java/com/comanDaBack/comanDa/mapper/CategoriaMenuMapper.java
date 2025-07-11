package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.CategoriaMenuDTO;
import com.comanDaBack.comanDa.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMenuMapper {

    @Mapping(source = "nombreCategoria" , target="nombreCategoriaMenu")
    @Mapping(source= "idCategoria" , target="idCategoria")
    CategoriaMenuDTO toDTO(Categoria categoria);


    @Mapping(target = "ingredientes", ignore = true)
    @Mapping(target = "menus", ignore = true)
    Categoria toEntity(CategoriaMenuDTO categoriaMenuDTO);
}

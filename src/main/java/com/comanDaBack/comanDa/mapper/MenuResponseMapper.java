package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.MenuResponseDTO;
import com.comanDaBack.comanDa.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" )
public interface MenuResponseMapper {

    @Mapping(source = "categoria.nombreCategoria" ,  target="nombreCategoria")
    MenuResponseDTO toDTO(Menu menu);


}

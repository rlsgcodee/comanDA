package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.MenuRequestDTO;
import com.comanDaBack.comanDa.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MenuRequestMapper {
    @Mapping(target="idMenu" ,  ignore = true)
    @Mapping(target = "categoria" , ignore =true)
    Menu toMenu(MenuRequestDTO menuRequestDTO);

    void updateMenuFromDTO(MenuRequestDTO dto, @MappingTarget Menu entity);

}

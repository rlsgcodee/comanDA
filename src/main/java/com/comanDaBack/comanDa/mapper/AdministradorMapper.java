package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.AdministradorDTO;
import com.comanDaBack.comanDa.entity.Administrador;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface AdministradorMapper {
    AdministradorDTO toDTO(Administrador administrador);

    Administrador toEntity(AdministradorDTO administradorDTO);
}

package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.AdministradorResponseDTO;
import com.comanDaBack.comanDa.entity.Administrador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface AdministradorResponseMapper {
    @Mapping(source = "idUsuario.idUsuario" , target = "idUsuario")
    AdministradorResponseDTO toDTO(Administrador administrador);


}

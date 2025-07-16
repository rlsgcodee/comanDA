package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.AdministradorResponseDTO;
import com.comanDaBack.comanDa.dto.AdministradorRequestDTO;
import com.comanDaBack.comanDa.entity.Administrador;
import com.comanDaBack.comanDa.security.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdministradorRequestMapper {
   //a esto los ignoro xq no son valores que voy a pasar desde el front
    @Mapping(target = "idAdmin" ,  ignore = true)
    @Mapping(target = "idUsuario", ignore = true)
    Administrador toAdministrador(AdministradorRequestDTO administradorRequestDTO);

    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "isEnabled", constant = "true")
    @Mapping(target = "isAccountNonExpired", constant = "true")
    @Mapping(target = "isCredentialNonExpired", constant = "true")
    @Mapping(target = "isAccountNonLocked", constant = "true")
    Usuario toUsuario(AdministradorRequestDTO administradorRequestDTO);


}

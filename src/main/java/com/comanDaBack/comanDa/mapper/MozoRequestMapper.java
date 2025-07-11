package com.comanDaBack.comanDa.mapper;


import com.comanDaBack.comanDa.dto.MozoRequestDTO;
import com.comanDaBack.comanDa.entity.Mozo;
import com.comanDaBack.comanDa.security.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MozoRequestMapper {
    @Mapping(target = "idMozo", ignore = true)
    @Mapping(target = "fechaAlta", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "idUsuario", ignore = true)
    Mozo toMozo(MozoRequestDTO dto);

    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "isEnabled", constant = "true")
    @Mapping(target = "isAccountNonExpired", constant = "true")
    @Mapping(target = "isCredentialNonExpired", constant = "true")
    @Mapping(target = "isAccountNonLocked", constant = "true")
    Usuario toUsuario(MozoRequestDTO dto);

}

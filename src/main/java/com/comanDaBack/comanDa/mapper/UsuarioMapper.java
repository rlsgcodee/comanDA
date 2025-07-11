package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.UsuarioDTO;
import com.comanDaBack.comanDa.security.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDTO toDTO(Usuario usuario);
    @Mapping(target = "username" , ignore = true)
    @Mapping(target = "password" , ignore = true)
    @Mapping(target = "isEnabled" , ignore = true)
    @Mapping(target = "isAccountNonExpired" , ignore = true)
    @Mapping(target = "isCredentialNonExpired" , ignore = true)
    @Mapping(target = "isAccountNonLocked" , ignore = true)
    @Mapping(target = "role" , ignore = true)
    Usuario toEntity(UsuarioDTO usuarioDTO);
}

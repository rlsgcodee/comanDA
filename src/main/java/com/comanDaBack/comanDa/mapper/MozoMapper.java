package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.MozoDTO;
import com.comanDaBack.comanDa.entity.Mozo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface MozoMapper {

    MozoDTO toDTO(Mozo mozo);

    Mozo toEntity(MozoDTO mozoDTO);

}

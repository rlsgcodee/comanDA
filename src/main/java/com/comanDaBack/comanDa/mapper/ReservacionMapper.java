package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.ReservacionRequestDTO;
import com.comanDaBack.comanDa.dto.ReservacionResponseDTO;
import com.comanDaBack.comanDa.entity.Reservacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring" ,uses = {MesaRequestMapper.class})
public interface ReservacionMapper {

    Reservacion toEntity(ReservacionRequestDTO reservacionRequestDTO);

    @Mapping(source = "mesa.numMesa", target= "numMesa")
    ReservacionResponseDTO toDTO(Reservacion reservacion);

    @Mapping(target = "idReservacion", ignore = true)
    void updateReservacionFromDto(ReservacionRequestDTO dto, @MappingTarget Reservacion reservacion);

}

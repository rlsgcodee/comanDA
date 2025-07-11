package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.ReservacionDTO;
import com.comanDaBack.comanDa.entity.Reservacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" ,uses = {MesaRequestMapper.class})
public interface ReservacionMapper {
    ReservacionDTO toDTO(Reservacion reservacion);

    Reservacion toEntity(ReservacionDTO reservacionDTO);

}

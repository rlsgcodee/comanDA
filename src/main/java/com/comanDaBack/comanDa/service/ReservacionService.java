package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.ReservacionRequestDTO;
import com.comanDaBack.comanDa.dto.ReservacionResponseDTO;

public interface ReservacionService {

    ReservacionResponseDTO guardarReservacion(ReservacionRequestDTO reservacionRequestDTO);

    ReservacionResponseDTO modificarReservacion(Long idReservacion, ReservacionRequestDTO reservacionRequestDTO);

    void eliminarReservacion(Long idReservacion);
}

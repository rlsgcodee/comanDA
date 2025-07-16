package com.comanDaBack.comanDa.service;


import com.comanDaBack.comanDa.dto.ReservacionRequestDTO;
import com.comanDaBack.comanDa.dto.ReservacionResponseDTO;
import com.comanDaBack.comanDa.entity.EstadoMesa;
import com.comanDaBack.comanDa.entity.Mesa;
import com.comanDaBack.comanDa.entity.Reservacion;
import com.comanDaBack.comanDa.exception.custom.DuplicadoException;
import com.comanDaBack.comanDa.exception.custom.NotFoundException;
import com.comanDaBack.comanDa.mapper.ReservacionMapper;
import com.comanDaBack.comanDa.repository.MesaRepository;
import com.comanDaBack.comanDa.repository.ReservacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservacionImplService implements ReservacionService{
    private final ReservacionRepository reservacionRepository;
    private final ReservacionMapper reservacionMapper;
    private final MesaRepository mesaRepository;



    @Override
    public ReservacionResponseDTO guardarReservacion(ReservacionRequestDTO reservacionRequestDTO) {
        Reservacion reservacion = reservacionMapper.toEntity(reservacionRequestDTO);

        reservacion.setMesa(validarMesa(reservacionRequestDTO.getIdMesa()));

        reservacion.setFechaHora(LocalDateTime.now());

        Reservacion nuevaReservacion = reservacionRepository.save(reservacion);

        return reservacionMapper.toDTO(nuevaReservacion);
    }

    @Override
    public ReservacionResponseDTO modificarReservacion(Long idReservacion, ReservacionRequestDTO reservacionRequestDTO) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion).orElseThrow(()-> new NotFoundException("No se encontró la reservación"));

        if (!reservacion.getMesa().getIdMesa().equals(reservacionRequestDTO.getIdMesa())) {
            Mesa nuevaMesa = validarMesa(reservacionRequestDTO.getIdMesa());
            reservacion.setMesa(nuevaMesa);
        }
        reservacionMapper.updateReservacionFromDto(reservacionRequestDTO,reservacion);

        Reservacion reservacionModificada = reservacionRepository.save(reservacion);

        return reservacionMapper.toDTO(reservacionModificada);
    }

    @Override
    public void eliminarReservacion(Long idReservacion) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion).orElseThrow(()-> new NotFoundException("No se encontró el id"));
        Mesa mesa = reservacion.getMesa();
        if (mesa.getEstadoMesa() == EstadoMesa.RESERVADA){
            mesa.setEstadoMesa(EstadoMesa.DISPONIBLE);
            mesaRepository.save(mesa);
        }
        reservacionRepository.delete(reservacion);
    }
    //************************************************
    private Mesa validarMesa(Long idMesa){
        Mesa mesa = mesaRepository.findById(idMesa).orElseThrow(() -> new NotFoundException("No se encontro la mesa"));
        if(mesa.getEstadoMesa() == EstadoMesa.DISPONIBLE){
            mesa.setEstadoMesa(EstadoMesa.RESERVADA);
            mesaRepository.save(mesa);
        }else {
            throw  new DuplicadoException("La mesa no se encuentra disponible");
        }
        return mesa;
    }

}

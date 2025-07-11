package com.comanDaBack.comanDa.service;


import com.comanDaBack.comanDa.dto.MesaRequestDTO;
import com.comanDaBack.comanDa.dto.MesaResponseDTO;
import com.comanDaBack.comanDa.entity.EstadoMesa;
import com.comanDaBack.comanDa.entity.Mesa;
import com.comanDaBack.comanDa.entity.Mozo;
import com.comanDaBack.comanDa.exception.custom.DuplicadoException;
import com.comanDaBack.comanDa.exception.custom.NotFoundException;
import com.comanDaBack.comanDa.mapper.MesaRequestMapper;
import com.comanDaBack.comanDa.mapper.MesaResponseMapper;
import com.comanDaBack.comanDa.repository.MesaRepository;
import com.comanDaBack.comanDa.repository.MozoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MesaServiceImpl implements MesaService {
   private final MesaRepository mesaRepository;
   private final MesaRequestMapper mesaRequestMapper;
   private final MesaResponseMapper mesaResponseMapper;
   private final MozoRepository mozoRepository;



    @Override
    public MesaResponseDTO guardarMesa(MesaRequestDTO mesaRequestDTO) {
        Mozo mozo = mozoRepository.findById(mesaRequestDTO.getIdMozo()).orElseThrow(() -> new NotFoundException("Mozo no encontrado"));
        numeroMesaYaExiste(mesaRequestDTO.getNumMesa());
        Mesa mesa = mesaRequestMapper.toEntity(mesaRequestDTO);
        mesa.setMozo(mozo);
        mesa.setEstadoMesa(EstadoMesa.DISPONIBLE);

        Mesa mesaGuardada = mesaRepository.save(mesa);
        return mesaResponseMapper.toDTO(mesaGuardada);
    }

    @Override
    public MesaResponseDTO modificarMesa(Long idMesa, MesaRequestDTO mesaRequestDTO) {
        Mozo mozo = mozoRepository.findById(mesaRequestDTO.getIdMozo()).orElseThrow(() -> new NotFoundException("Mozo no encontrado"));
        numeroMesaYaExiste(mesaRequestDTO.getNumMesa());
        Mesa mesa = mesaRepository.findById(idMesa).orElseThrow(() -> new NotFoundException(("No se encontro la mesa")));
        mesaRequestMapper.updateMesaFromDTO(mesaRequestDTO, mesa);
        mesa.setMozo(mozo);
        mesa.setEstadoMesa(mesaRequestDTO.getEstadoMesa());

        Mesa mesaModificada = mesaRepository.save(mesa);
        return mesaResponseMapper.toDTO(mesaModificada);
    }

    @Override
    public void eliminarMesa(Long idMesa) {
        Mesa mesa = mesaRepository.findById(idMesa).orElseThrow(() -> new NotFoundException("La mesa no existe"));
        mesaRepository.delete(mesa);
    }

    @Override
    public List<MesaResponseDTO> listarMesas() {
        List<Mesa> mesas = mesaRepository.findAll();
        return mesas.stream().map(mesaResponseMapper::toDTO).toList();
    }


    //************************************************************************
    private void numeroMesaYaExiste(int numMesa){
        if (mesaRepository.existsByNumMesa(numMesa)){
            throw new DuplicadoException("El número de mesa ya existe");
        }
    }
}

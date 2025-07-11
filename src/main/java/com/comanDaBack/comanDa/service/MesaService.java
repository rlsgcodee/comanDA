package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.MesaRequestDTO;
import com.comanDaBack.comanDa.dto.MesaResponseDTO;

import java.util.List;

public interface MesaService {
    MesaResponseDTO guardarMesa(MesaRequestDTO mesaRequestDTO);

    MesaResponseDTO modificarMesa(Long idMesa, MesaRequestDTO mesaRequestDTO);

    void eliminarMesa(Long idMesa);

    List<MesaResponseDTO> listarMesas();
}

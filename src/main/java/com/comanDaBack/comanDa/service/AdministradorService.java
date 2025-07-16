package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.AdministradorResponseDTO;
import com.comanDaBack.comanDa.dto.AdministradorRequestDTO;

public interface AdministradorService {
    AdministradorResponseDTO crearAdministrador(AdministradorRequestDTO administradorRequestDTO);
    boolean existeAdministrador();
}

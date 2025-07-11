package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.AdministradorDTO;
import com.comanDaBack.comanDa.dto.AdministradorRequestDTO;

public interface AdministradorService {
    AdministradorDTO crearAdministrador(AdministradorRequestDTO administradorRequestDTO);
    boolean existeAdministrador();
}

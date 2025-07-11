package com.comanDaBack.comanDa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministradorRequestDTO {
    private String nombreBar;
    private String cuit;
    private String telefono;
    private String direccion;
    private String email;
    private boolean esActivo;
    private String username;
    private String password;
}

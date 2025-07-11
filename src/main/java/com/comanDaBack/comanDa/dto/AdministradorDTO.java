package com.comanDaBack.comanDa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministradorDTO {

    private Long idAdmin;
    private String nombreBar;
    private String cuit;
    private String telefono;
    private String direccion;
    private LocalDateTime fechaAlta;
    private String email;
    private boolean esActivo;
    private UsuarioDTO idUsuario;
}

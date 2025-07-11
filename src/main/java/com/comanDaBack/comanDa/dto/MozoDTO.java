package com.comanDaBack.comanDa.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MozoDTO {
    private Long idMozo;
    private String nombreMozo;
    private String telefono;
    private String email;
    private boolean esActivo = true;
    private LocalDateTime fechaAlta;
    private UsuarioDTO idUsuario;

}

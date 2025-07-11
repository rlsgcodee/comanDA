package com.comanDaBack.comanDa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MozoRequestDTO {
    private String nombreMozo;
    private String telefono;
    private String email;
    private boolean esActivo = true;
    private String username;
    private String password;
}

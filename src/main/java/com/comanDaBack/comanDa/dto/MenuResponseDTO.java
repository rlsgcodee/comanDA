package com.comanDaBack.comanDa.dto;

import lombok.Data;

@Data
public class MenuResponseDTO {
        private Long idMenu;
        private String nombreMenu;
        private String descripcion;
        private double precio;
        private boolean esDisponible;
        private String nombreCategoria;
}

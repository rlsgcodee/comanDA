package com.comanDaBack.comanDa.dto;


import lombok.Data;


@Data
public class MenuRequestDTO {
    private String nombreMenu;
    private String descripcion;
    private double precio;
    private boolean esDisponible;
    private Long idCategoria;
}

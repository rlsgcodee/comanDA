package com.comanDaBack.comanDa.dto;

import lombok.Data;
import java.util.List;

@Data
public class CategoriaMenuResponseDTO {
    private String nombreCategoria;
    private List<MenuResponseDTO> menus;
}

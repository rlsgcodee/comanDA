package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.MenuRequestDTO;
import com.comanDaBack.comanDa.dto.MenuResponseDTO;

import java.util.List;

public interface MenuService {
    MenuResponseDTO guardarMenu(MenuRequestDTO menuRequestDTO);
    MenuResponseDTO modificarMenu(Long idMenu, MenuRequestDTO menuRequestDTO);
    List<MenuResponseDTO> listarMenus();
    void eliminarMenu(Long idMenu);
    MenuResponseDTO desactivarMenu(Long idMenu , MenuRequestDTO menuRequestDTO);
    List<MenuResponseDTO> buscarMenuPorNombre(String nombreMenu);
}

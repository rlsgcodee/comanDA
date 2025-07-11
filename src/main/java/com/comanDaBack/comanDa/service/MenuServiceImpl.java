package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.MenuRequestDTO;
import com.comanDaBack.comanDa.dto.MenuResponseDTO;
import com.comanDaBack.comanDa.entity.Categoria;
import com.comanDaBack.comanDa.entity.Menu;
import com.comanDaBack.comanDa.exception.custom.DuplicadoException;
import com.comanDaBack.comanDa.exception.custom.NotFoundException;
import com.comanDaBack.comanDa.mapper.MenuRequestMapper;
import com.comanDaBack.comanDa.mapper.MenuResponseMapper;
import com.comanDaBack.comanDa.repository.CategoriaRepository;
import com.comanDaBack.comanDa.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuRequestMapper menuRequestMapper;
    private final MenuResponseMapper menuResponseMapper;
    private final CategoriaRepository categoriaRepository;

    @Override
    public MenuResponseDTO guardarMenu(MenuRequestDTO menuRequestDTO) {
    Categoria categoria = categoriaRepository.findById(menuRequestDTO.getIdCategoria()).orElseThrow(() -> new NotFoundException("No se encontro Id de la categoria"));
    validarNombre(menuRequestDTO.getNombreMenu());
    Menu menu = menuRequestMapper.toMenu(menuRequestDTO);
    menu.setCategoria(categoria);
    Menu guardarMenu = menuRepository.save(menu);
        return menuResponseMapper.toDTO(guardarMenu) ;
    }

    @Override
    public List<MenuResponseDTO> listarMenus() {
        List<Menu> menus = menuRepository.findAll();
        return menus.stream().map(menuResponseMapper::toDTO).toList();
    }

    @Override
    public MenuResponseDTO modificarMenu(Long idMenu, MenuRequestDTO menuRequestDTO) {
        Categoria categoria = categoriaRepository.findById(menuRequestDTO.getIdCategoria()).orElseThrow(()-> new NotFoundException("No se encontro la categoria") );
        validarNombre(menuRequestDTO.getNombreMenu());
        Menu menu = menuRepository.findById(idMenu).orElseThrow(() -> new NotFoundException("No se encontró el menu"));

        menuRequestMapper.updateMenuFromDTO(menuRequestDTO, menu);
        menu.setCategoria(categoria);
        Menu menuActualizado = menuRepository.save(menu);
        return menuResponseMapper.toDTO(menuActualizado);
    }

    @Override
    public void eliminarMenu(Long idMenu) {
        Menu menu = menuRepository.findById(idMenu).orElseThrow(() -> new NotFoundException("No se encontró el menu"));
        menuRepository.delete(menu);
    }

    @Override
    public MenuResponseDTO desactivarMenu(Long idMenu , MenuRequestDTO menuRequestDTO) {
        Menu menu = menuRepository.findById(idMenu).orElseThrow(() -> new NotFoundException("No se encontró el menu"));
        menu.setEsDisponible(false);
        Menu menuActualizado = menuRepository.save(menu);
        return menuResponseMapper.toDTO(menuActualizado);
    }

    @Override
    public List<MenuResponseDTO> buscarMenuPorNombre(String nombreMenu) {
        List<Menu> menu = menuRepository.findByNombreMenuContainingIgnoreCase(nombreMenu);
        return menu.stream().map(menuResponseMapper::toDTO).toList();
    }


    //*********************************************************************************
    private void validarNombre(String nombreMenu){
        if (menuRepository.existsByNombreMenu(nombreMenu)){
            throw new DuplicadoException("Ya existe un menu con el mismo nombre");
        }
    }
}

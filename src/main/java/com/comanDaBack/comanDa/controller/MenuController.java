package com.comanDaBack.comanDa.controller;

import com.comanDaBack.comanDa.dto.MenuRequestDTO;
import com.comanDaBack.comanDa.dto.MenuResponseDTO;
import com.comanDaBack.comanDa.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/guardarMenu")
    @Operation(
            summary = "Registrar un nuevo menú",
            description = "Este endpoint permite crear un nuevo menú y asociarlo a una categoría de tipo MENÚ previamente registrada. Solo usuarios con rol ADMIN pueden acceder. Devuelve los datos completos del menú creado, incluyendo su ID.",
            tags = {"Gestión Menu"}
    )
    public ResponseEntity<MenuResponseDTO> guardarMenu(@RequestBody MenuRequestDTO menu){
        return ResponseEntity.ok(menuService.guardarMenu(menu));
    }

    @GetMapping("/listarMenus")
    @Operation(
            summary = "Listar todos los menús",
            description = "Devuelve una lista completa de todos los menús registrados en el sistema, sin filtrar por categoría. Acceso permitido a usuarios autenticados con rol ADMIN o MOZO.",
            tags = {"Gestión Menu"}
    )
    public List<MenuResponseDTO> listarMenus(){
        return menuService.listarMenus();
    }

    @PutMapping("/modificarMenu/{idMenu}")
    @Operation(
            summary = "Modificar un menú existente",
            description = "Permite actualizar los datos de un menú registrado, como nombre, precio, descripción o categoría asociada. Requiere autenticación y permisos de usuario con rol ADMIN. Devuelve el menú actualizado.",
            tags = {"Gestión Menu"}
    )
    public ResponseEntity<MenuResponseDTO> modificarMenu(@PathVariable Long idMenu , @RequestBody MenuRequestDTO menuRequestDTO){
        return ResponseEntity.ok(menuService.modificarMenu(idMenu, menuRequestDTO));
    }

    @DeleteMapping("/{idMenu}")
    @Operation(
            summary = "Eliminar un menú",
            description = "Elimina un menú existente identificado por su ID. Solo accesible por usuarios con rol ADMIN. No retorna contenido en caso de éxito.",
            tags = {"Gestión Menu"}
    )
    public void eliminarMenu(@PathVariable Long idMenu){
        menuService.eliminarMenu(idMenu);
    }

    @PutMapping("/descativarMenu/{idMenu}")
    @Operation(
            summary = "Desactivar un menú",
            description = "Este endpoint permite desactivar un menú existente, marcándolo como inactivo para que no esté disponible para nuevos pedidos. Devuelve el menú actualizado con su estado.",
            tags = {"Gestión Menu"}
    )
    public ResponseEntity<MenuResponseDTO> desactivarMenu(@PathVariable Long idMenu, @RequestBody MenuRequestDTO menuRequestDTO){
        return ResponseEntity.ok(menuService.desactivarMenu(idMenu, menuRequestDTO));
    }

    @GetMapping("/buscarMenuPorNombre/{nombreMenu}")
    @Operation(
            summary = "Buscar menús por nombre",
            description = "Este endpoint permite buscar menús cuyo nombre contenga el texto proporcionado. Devuelve una lista de menús que coinciden parcial o totalmente con el criterio de búsqueda.",
            tags = {"Gestión Menu"}
    )
    public List<MenuResponseDTO> buscarMenuPorNombre(@PathVariable String nombreMenu){
        return menuService.buscarMenuPorNombre(nombreMenu);
    }

}

package com.comanDaBack.comanDa.controller;

import com.comanDaBack.comanDa.dto.CategoriaIngreResponseDTO;
import com.comanDaBack.comanDa.dto.CategoriaIngredienteDTO;
import com.comanDaBack.comanDa.dto.CategoriaMenuResponseDTO;
import com.comanDaBack.comanDa.dto.CategoriaMenuDTO;
import com.comanDaBack.comanDa.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;


    @PostMapping("/guardarCategoriaIngrediente")
    @Operation(
            summary = "Guardar Categoria Ingrediente",
            description = "Ingredientes tiene categoria y para que no se mezcle con categoria del menu lo clasificamos",
            tags = {"Categoria Ingrediente"}
    )
    public ResponseEntity<CategoriaIngredienteDTO> guardarCategoriaIngrediente(@RequestBody CategoriaIngredienteDTO categoriaIngredienteDTO){
        return ResponseEntity.ok(categoriaService.guardarCategoriaIngrediente(categoriaIngredienteDTO));
    }

    @PostMapping("/guardarCategoriaMenu")
    @Operation(
            summary = "Guardar Categoria Menu",
            description = "Menu tiene categoria y para que no se mezcle con categoria de los ingrediente lo clasificamos",
            tags = {"Categoria Menu"}
    )
    public ResponseEntity<CategoriaMenuDTO> guardarCategoriaMenu(@RequestBody CategoriaMenuDTO categoriaMenuDTO){
        return  ResponseEntity.ok(categoriaService.guardarCategoriaMenu(categoriaMenuDTO));
    }

    @GetMapping("/categorias-ingredientes")
    @Operation(
            summary = "Listar las categorías disponibles de ingredientes",
            description = "Este endpoint se utiliza al registrar un nuevo ingrediente," +
                    " para mostrar las categorías de tipo ingrediente ya creadas en el sistema.",
            tags = {"Categoria Ingrediente"}
    )
    public ResponseEntity<List<CategoriaIngredienteDTO>> listarCatIngCreadas() {
        return ResponseEntity.ok(categoriaService.listarCatIngCreadas());
    }

    @GetMapping("/categorias-menus")
    @Operation(
            summary = "Listar las categorías disponibles de menu",
            description = "Este endpoint se utiliza al registrar un nuevo menu," +
                    "para mostrar las categorías de tipo ingrediente ya creadas en el sistema",
            tags = {"Categoria Menu"}
    )
    public ResponseEntity<List<CategoriaMenuDTO>> listarCatMenuCreadas() {
        return ResponseEntity.ok(categoriaService.listarCatMenuCreadas());
    }

    @GetMapping("/listarIngredientesConCategoria/{idCategoria}")
    @Operation(
            summary = "Lista una categoria con una lista de ingrediente asociado",
            description = "Este endpoint es para usarlo para cuando quieramos seleccionar una categoria del " +
                    "ingrediente y se puedan listar los ingredientes asociados",
            tags = {"Categoria Ingrediente"}
    )
    public ResponseEntity<CategoriaIngreResponseDTO> listarIngredienteConCategoria(@PathVariable Long idCategoria){
        return ResponseEntity.ok(categoriaService.listarIngredienteConCategoria(idCategoria));
    }

    @GetMapping("/listarMenusConCategoria/{idCategoria}")
    @Operation(
            summary = "Lista una categoria con una lista de menu asociado",
            description = "Este endpoint es para usarlo para cuando quieramos seleccionar" +
                    "una categoria del menu y se puedan listar los menus asociados",
            tags = {"Categoria Menu"}
    )
    public ResponseEntity<CategoriaMenuResponseDTO> listarMenuConCategoria(@PathVariable Long idCategoria){
        return ResponseEntity.ok(categoriaService.listarMenuConCategoria(idCategoria));
    }



}

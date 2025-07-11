package com.comanDaBack.comanDa.controller;


import com.comanDaBack.comanDa.dto.IngredienteRequestDTO;
import com.comanDaBack.comanDa.dto.IngredienteResponseDTO;
import com.comanDaBack.comanDa.service.IngredienteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ingrediente")
public class IngredienteController {
    private final IngredienteService ingredienteService;

    @GetMapping("/listarIngredientes")
    @Operation(
            summary = "Obtener todos los ingredientes",
            description = "Este endpoint devuelve la lista completa de ingredientes almacenados en el sistema.",
            tags = {"Gestión Ingrediente"}
    )
    public ResponseEntity<List<IngredienteResponseDTO>> listarIngredientes(){
        return ResponseEntity.ok(ingredienteService.listarIngredientes());
    }

    @PostMapping("/guardarIngrediente")
    @Operation(
            summary = "Registrar un nuevo ingrediente",
            description = "Permite guardar un ingrediente. La unidad de medida debe ser una de las siguientes: UNIDAD, GRAMO, KILOGRAMO, LITRO, MILILITRO..",
            tags = {"Gestión Ingrediente"}
    )
    public ResponseEntity<IngredienteResponseDTO> guardarIngrediente(@RequestBody IngredienteRequestDTO ingredienteRequestDTO){
        return ResponseEntity.ok(ingredienteService.guardarIngrediente(ingredienteRequestDTO));
    }


    @PutMapping("/modificarIngrediente/{idIngrediente}")
    @Operation(
            summary = "Modificar un ingrediente existente",
            description = "Actualiza los datos de un ingrediente previamente registrado. Se requiere el ID del ingrediente a modificar. Solo los usuarios con rol ADMIN pueden acceder a este endpoint.",
            tags = {"Gestión Ingrediente"}
    )
    public ResponseEntity<IngredienteResponseDTO> modificarIngrediente(@PathVariable Long idIngrediente, @RequestBody IngredienteRequestDTO ingredienteRequestDTO){
        return  ResponseEntity.ok(ingredienteService.modificarIngrediente(idIngrediente,ingredienteRequestDTO));
    }


    @GetMapping("/listarIngredientesByNombre/{nombreIngrediente}")
    @Operation(
            summary = "Buscar ingrediente por nombre",
            description = "Este endpoint permite buscar ingredientes cuyo nombre contenga el texto proporcionado. Es útil para autocompletado o filtros dinámicos.",
            tags = {"Gestión Ingrediente"}
    )
    public ResponseEntity<List<IngredienteResponseDTO>> findByNombreIngrediente(@RequestParam String nombreIngrediente){
        List<IngredienteResponseDTO> ingredientes = ingredienteService.findByNombreIngrediente(nombreIngrediente);
        return ResponseEntity.ok(ingredientes);
    }

    @DeleteMapping("{idIngrediente}")
    @Operation(
            summary = "Eliminar ingrediente",
            description = "Este endpoint permite eliminar un ingrediente del sistema a partir de su identificador único (ID).",
            tags = {"Gestión Ingrediente"}
    )
    public void eliminarIngrediente(@PathVariable Long idIngrediente){
        ingredienteService.eliminarIngrediente(idIngrediente);
    }



}

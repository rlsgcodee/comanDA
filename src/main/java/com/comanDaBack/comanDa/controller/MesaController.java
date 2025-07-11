package com.comanDaBack.comanDa.controller;


import com.comanDaBack.comanDa.dto.MesaRequestDTO;
import com.comanDaBack.comanDa.dto.MesaResponseDTO;
import com.comanDaBack.comanDa.service.MesaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mesa")
public class MesaController {
    private final MesaService mesaService;


    @PostMapping("/guardarMesa")
    @Operation(
            summary = "Registrar una nueva mesa",
            description = "Este endpoint permite guardar una nueva mesa en el sistema, incluyendo su número, capacidad u otros datos. Solo accesible para usuarios con rol ADMIN. Devuelve los datos completos de la mesa creada.",
            tags = {"Gestion Mesas"}
    )
    public ResponseEntity<MesaResponseDTO> guardarMesa(@RequestBody MesaRequestDTO mesaRequestDTO){
        MesaResponseDTO mesa = mesaService.guardarMesa(mesaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mesa);
    }

    @PutMapping("/modificarMesa/{idMesa}")
    @Operation(
            summary = "Modificar una mesa existente",
            description = "Este endpoint permite actualizar los datos de una mesa registrada, como su número, estado o capacidad. Solo accesible por usuarios con rol ADMIN. Devuelve la información actualizada de la mesa.",
            tags = {"Gestion Mesas"}
    )
    public ResponseEntity<MesaResponseDTO> modificarMesa(@PathVariable Long idMesa, @RequestBody MesaRequestDTO mesaRequestDTO){
        MesaResponseDTO mesa = mesaService.modificarMesa(idMesa, mesaRequestDTO);
        return ResponseEntity.ok(mesa);
    }

    @DeleteMapping("/eliminarMesa/{idMesa}")
    @Operation(
            summary = "Eliminar una mesa",
            description = "Este endpoint permite eliminar una mesa del sistema a partir de su identificador (ID). Solo accesible por usuarios con rol ADMIN. No retorna contenido en caso de éxito.",
            tags = {"Gestion Mesas"}
    )
    public ResponseEntity<Void> eliminarMesa(@PathVariable Long idMesa){
        mesaService.eliminarMesa(idMesa);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listarMesas")
    @Operation(
            summary = "Listar todas las mesas",
            description = "Devuelve una lista completa de todas las mesas registradas en el sistema, incluyendo detalles como número de mesa, capacidad, estado actual y el nombre del mozo asociado a cada mesa.",
            tags = {"Gestion Mesas"}
    )
    public ResponseEntity<List<MesaResponseDTO>> listarMesas(){
        return ResponseEntity.ok(mesaService.listarMesas());
    }
}

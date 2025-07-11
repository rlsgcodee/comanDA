package com.comanDaBack.comanDa.controller;

import com.comanDaBack.comanDa.dto.MovimientoStockRequestDTO;
import com.comanDaBack.comanDa.dto.MovimientoStockResponseDTO;
import com.comanDaBack.comanDa.service.MovimientoStockService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movimientoStock")
public class MovimientoStockController {
    private final MovimientoStockService movimientoStockService;

    @PostMapping("/guardarMovimientoStock")
    @Operation(
            summary = "Registrar un movimiento de stock",
            description = "Este endpoint permite registrar un movimiento de stock (entrada o salida) para un ingrediente, actualizando así la cantidad disponible en el inventario.",
            tags = {"Movimiento Stock"}
    )
    public ResponseEntity<MovimientoStockResponseDTO> guardarMovimientoStock(@RequestBody MovimientoStockRequestDTO movimientoStock){
        return ResponseEntity.ok(movimientoStockService.guardarMovimientoStock(movimientoStock));
    }

    @GetMapping("/listarmovimientos")
    @Operation(
            summary = "Listar movimientos de stock",
            description = "Devuelve el historial completo de movimientos de stock registrados, incluyendo entradas y salidas asociadas a los ingredientes.",
            tags = {"Movimiento Stock"}
    )

    public List<MovimientoStockResponseDTO> listarMovimientos(){
        return movimientoStockService.listarMovimientos();
    }
}

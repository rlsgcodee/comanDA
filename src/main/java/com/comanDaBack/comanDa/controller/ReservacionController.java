package com.comanDaBack.comanDa.controller;

import com.comanDaBack.comanDa.dto.ReservacionRequestDTO;
import com.comanDaBack.comanDa.dto.ReservacionResponseDTO;
import com.comanDaBack.comanDa.service.ReservacionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservacion")
public class ReservacionController {
    private final ReservacionService reservacionService;


    @PostMapping("/guardarReservacion")
    @Operation(
            summary = "Guardar una nueva reservación",
            description = "Este endpoint permite guardar una nueva reservación asociada a una mesa específica. " +
                    "Solo se permite la reservación si la mesa está disponible. " +
                    "Devuelve los datos completos de la reservación registrada, incluyendo el estado actualizado de la mesa.",
            tags = {"Gestión Reservación"}

            )
    public ResponseEntity<ReservacionResponseDTO> guardarReservacion(@RequestBody  ReservacionRequestDTO reservacionRequestDTO){
        return ResponseEntity.ok(reservacionService.guardarReservacion(reservacionRequestDTO));
    }

    @PutMapping("/modificarReservacion")
    @Operation(
            summary = "Modificar una reservación existente",
            description = "Permite actualizar los datos de una reservación previamente registrada mediante su ID. " +
                    "Se puede modificar la fecha, el cliente u otros detalles asociados. " +
                    "Devuelve la información actualizada de la reservación.",
            tags = {"Gestión Reservación"}
    )
    public ResponseEntity<ReservacionResponseDTO> modificarReservacion(@PathVariable Long idReservacion, @RequestBody ReservacionRequestDTO reservacionRequestDTO){
        return ResponseEntity.ok(reservacionService.modificarReservacion(idReservacion, reservacionRequestDTO));
    }

    @DeleteMapping("/eliminarReservacion/{idReservacion}")
    @Operation(
            summary = "Eliminar una reservación",
            description = "Elimina una reservación existente según su ID. Si la reservación no existe. ",
            tags = {"Gestión Reservación"}
    )
    public ResponseEntity<String> eliminarReservacion(@PathVariable Long idReservacion){
        reservacionService.eliminarReservacion(idReservacion);
        return ResponseEntity.ok("Se elimino ");
    }

}

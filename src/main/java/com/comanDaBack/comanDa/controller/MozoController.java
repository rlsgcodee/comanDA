package com.comanDaBack.comanDa.controller;


import com.comanDaBack.comanDa.dto.MozoDTO;
import com.comanDaBack.comanDa.dto.MozoRequestDTO;
import com.comanDaBack.comanDa.service.MozoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mozos")
public class MozoController {
    private  final MozoService mozoService;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/guardarMozo")
    @Operation(
            summary = "Registrar un nuevo mozo",
            description = "Este endpoint permite registrar un nuevo mozo en el sistema. Solo puede ser accedido por usuarios con rol ADMIN. El mozo registrado se devuelve con su ID y datos completos.",
            tags = {"Gestion Mozo"}
    )
    public ResponseEntity<MozoDTO> crearMozo(@RequestBody MozoRequestDTO dto) {
        MozoDTO creado = mozoService.crearMozoConUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

}

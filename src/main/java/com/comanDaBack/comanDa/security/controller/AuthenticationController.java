package com.comanDaBack.comanDa.security.controller;


import com.comanDaBack.comanDa.dto.AdministradorResponseDTO;
import com.comanDaBack.comanDa.dto.AdministradorRequestDTO;
import com.comanDaBack.comanDa.security.dto.AuthLoginRequest;
import com.comanDaBack.comanDa.security.dto.AuthResponse;
import com.comanDaBack.comanDa.security.service.UserDetailServiceImpl;
import com.comanDaBack.comanDa.service.AdministradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserDetailServiceImpl userDetailService;
    private final AdministradorService administradorService;



    @PostMapping("/log-in")
    @Operation(
            summary = "Login User",
            description = "Para acceder a la mayoría de los endpoints es necesario autenticarse usando JWT. " +
                    "Obtené el token con el endpoint de login y luego usá el botón 'Authorize' para agregarlo automáticamente en cada petición.",
            tags = {"Authentication"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Authentication request with username and password",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AuthLoginRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Succesful authentication",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = AuthResponse.class)
                            )
                    )
            }
    )
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest){
        return new ResponseEntity<>(this.userDetailService.loginUser(userRequest), HttpStatus.OK);
    }

    @PostMapping("/registro-admin")
    @Operation(
            summary = "Registrar un nuevo administrador",
            description = "Permite registrar un administrador solo si no existe uno previamente. Devuelve el administrador creado con su ID.",
            tags = {"Administración"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos para crear un nuevo administrador",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AdministradorRequestDTO.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Administrador creado exitosamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = AdministradorResponseDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Ya existe un administrador registrado"
                    )
            }
    )
    public ResponseEntity<AdministradorResponseDTO> registrarAdmin(@RequestBody @Valid AdministradorRequestDTO administradorRequestDTO) {
        if (administradorService.existeAdministrador()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Ya existe un administrador registrado");
        }
        AdministradorResponseDTO creado = administradorService.crearAdministrador(administradorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

}

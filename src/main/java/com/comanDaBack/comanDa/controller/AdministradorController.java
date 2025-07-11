package com.comanDaBack.comanDa.controller;


import com.comanDaBack.comanDa.service.AdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/administrador")
public class AdministradorController {
    private final AdministradorService administradorService;




}

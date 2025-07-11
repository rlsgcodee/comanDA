package com.comanDaBack.comanDa.entity;

import com.comanDaBack.comanDa.security.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mozo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMozo;
    private String nombreMozo;
    private String telefono;
    private String email;
    private boolean esActivo = true;
    private LocalDateTime fechaAlta;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;
}

package com.comanDaBack.comanDa.entity;

import com.comanDaBack.comanDa.security.entity.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;
    private String nombreBar;
    @Pattern(regexp="\\d{11}", message = "El cuit debe ser 11 dígitos numéricos")
    private String cuit;
    private String telefono;
    private String direccion;
    private LocalDateTime fechaAlta;
    private String email;
    private boolean esActivo;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

}

package com.comanDaBack.comanDa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservacion;
    private String nombreCliente;
    private String telefono;
    private int cantidadPersonas;
    private LocalDateTime fechaHora;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoMesa estadoMesa = EstadoMesa.RESERVADA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;


}

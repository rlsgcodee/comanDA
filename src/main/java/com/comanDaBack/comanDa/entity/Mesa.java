package com.comanDaBack.comanDa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMesa;
    private int numMesa;
    private int capacidad;
    @Enumerated(EnumType.STRING)
    private EstadoMesa estadoMesa;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mozo")
    @JsonBackReference
    private Mozo mozo;


}

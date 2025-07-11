package com.comanDaBack.comanDa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMenu;
    private String nombreMenu;
    private String descripcion;
    private double precio;
    private boolean esDisponible;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_categoria")
    @JsonBackReference
    private Categoria categoria;

}

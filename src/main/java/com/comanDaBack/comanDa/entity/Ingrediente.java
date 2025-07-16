package com.comanDaBack.comanDa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngrediente;
    private String nombreIngrediente;
    private LocalDateTime ultimaActualizacion;
    private int stockActual;
    @Enumerated(EnumType.STRING)
    private UnidadMedida unidadMedida;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_categoria")
    @JsonBackReference
    private Categoria categoria;

}

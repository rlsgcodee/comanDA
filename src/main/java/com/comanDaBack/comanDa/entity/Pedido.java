package com.comanDaBack.comanDa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;//
    private LocalDateTime fechaHora;//
    private double montoTotal;//

    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;//

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<DetallePedido> pedidos = new ArrayList<>();//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mozo")
    @JsonBackReference
    private Mozo mozo;//

}

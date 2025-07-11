package com.comanDaBack.comanDa.controller;

import com.comanDaBack.comanDa.dto.DetallePedidoRequestDTO;
import com.comanDaBack.comanDa.dto.PedidoMozoResponseDTO;
import com.comanDaBack.comanDa.dto.PedidoRequestDTO;
import com.comanDaBack.comanDa.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping("/guardarPedido")
    @Operation(
            summary = "Registrar un nuevo pedido",
            description = "Este endpoint permite guardar un nuevo pedido realizado por un mozo. Requiere que tanto el mozo como la mesa estén previamente registrados en el sistema. Solo puede ser accedido por usuarios con rol MOZO. Devuelve los datos completos del pedido registrado, incluyendo su ID y los detalles asociados.",
            tags = {"Pedido"}
    )
    public ResponseEntity<PedidoMozoResponseDTO> guardarPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO){
        PedidoMozoResponseDTO pedidoDTO = pedidoService.guardarPedido(pedidoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDTO);
    }

    @PatchMapping("/agregarProductos/{idPedido}")
    @Operation(
            summary = "Agregar productos a un pedido existente",
            description = "Permite añadir uno o más productos adicionales a un pedido previamente creado, sin modificar el resto de la información del pedido. El pedido debe existir y estar en un estado que permita modificaciones.",
            tags = {"Pedido"}
    )
    public ResponseEntity<PedidoMozoResponseDTO> agregarProductosAlPedido(@PathVariable Long idPedido,
            @RequestBody List<DetallePedidoRequestDTO> nuevosProductos) {

        PedidoMozoResponseDTO pedidoActualizado = pedidoService.agregarProductosAlPedido(idPedido, nuevosProductos);
        return ResponseEntity.ok(pedidoActualizado);
    }

    @GetMapping("/listarPedidos")
    @Operation(
            summary = "Listar todos los pedidos",
            description = "Devuelve una lista completa de todos los pedidos registrados en el sistema, incluyendo su estado, mozo asignado, mesa asociada y detalles del pedido. Acceso permitido a usuarios con rol ADMIN o MOZO.",
            tags = {"Pedido"}
    )
    public ResponseEntity<List<PedidoMozoResponseDTO>> listarPedidos(){
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }
}

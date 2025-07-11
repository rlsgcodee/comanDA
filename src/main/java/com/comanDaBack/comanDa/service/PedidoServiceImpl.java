package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.*;
import com.comanDaBack.comanDa.entity.*;
import com.comanDaBack.comanDa.exception.custom.NotFoundException;
import com.comanDaBack.comanDa.mapper.PedidoResponseMapper;
import com.comanDaBack.comanDa.mapper.PedidoRequestMapper;
import com.comanDaBack.comanDa.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    private final MesaRepository mesaRepository;
    private final MozoRepository mozoRepository;
    private final PedidoRepository pedidoRepository;
    private final PedidoRequestMapper pedidoRequestMapper;
    private final MenuRepository menuRepository;
    private final PedidoResponseMapper pedidoResponseMapper;

    @Override
    @Transactional
    public PedidoMozoResponseDTO guardarPedido(PedidoRequestDTO pedidoRequestDTO) {
        Pedido pedido = pedidoRequestMapper.toPedido(pedidoRequestDTO);

        //Asigno mesa
        Mesa mesa = mesaRepository.findById(pedidoRequestDTO.getIdMesa()).orElseThrow(() -> new NotFoundException("Mesa no disponible"));
        pedido.setMesa(mesa);

        //Asigno el mozo
        Mozo mozo = mozoRepository.findById(pedidoRequestDTO.getIdMozo()).orElseThrow(() -> new NotFoundException("Mozo no disponible"));
        pedido.setMozo(mozo);
        pedido.setFechaHora(LocalDateTime.now());
        pedido.setEstadoPedido(EstadoPedido.CREADO);
        // Calcular monto total y crear detalles
        double total = 0.0;
        List<DetallePedido> detalles = new ArrayList<>();

        for (DetallePedidoRequestDTO detalleDTO : pedidoRequestDTO.getDetalles()) {
            Menu menu = menuRepository.findById(detalleDTO.getIdMenu())
                    .orElseThrow(() -> new NotFoundException("Menú no encontrado"));

            DetallePedido detalle = new DetallePedido();
            detalle.setCantidad(detalleDTO.getCantidad());
            detalle.setMenu(menu);
            detalle.setPedido(pedido);

            total += menu.getPrecio() * detalleDTO.getCantidad();
            detalles.add(detalle);

        }

        pedido.setPedidos(detalles);
        pedido.setMontoTotal(total);

        Pedido guardado = pedidoRepository.save(pedido);

        return pedidoResponseMapper.toDTO(guardado);
    }

    @Override
    @Transactional
    public PedidoMozoResponseDTO agregarProductosAlPedido(Long idPedido, List<DetallePedidoRequestDTO> nuevosProductos) {
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new NotFoundException("Pedido no encontrado"));

        double total = pedido.getMontoTotal();

        List<DetallePedido> detallesNuevos = new ArrayList<>();

        for (DetallePedidoRequestDTO detalleDTO : nuevosProductos) {
            Menu menu = menuRepository.findById(detalleDTO.getIdMenu())
                    .orElseThrow(() -> new NotFoundException("Menú no encontrado"));

            DetallePedido detalle = new DetallePedido();
            detalle.setCantidad(detalleDTO.getCantidad());
            detalle.setMenu(menu);
            detalle.setPedido(pedido);

            total += menu.getPrecio() * detalleDTO.getCantidad();
            detallesNuevos.add(detalle);
        }

        pedido.getPedidos().addAll(detallesNuevos);
        pedido.setMontoTotal(total);

        Pedido pedidoActualizado = pedidoRepository.save(pedido);

        return pedidoResponseMapper.toDTO(pedidoActualizado);
    }

    @Override
    public List<PedidoMozoResponseDTO> listarPedidos() {
       List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(pedidoResponseMapper::toDTO).toList();
    }


}

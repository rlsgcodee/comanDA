package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.PedidoAgregarProductosDTO;
import com.comanDaBack.comanDa.dto.PedidoRequestDTO;
import com.comanDaBack.comanDa.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PedidoRequestMapper {

    Pedido toPedido(PedidoRequestDTO dto);

    void updatePedidoFromDTO(PedidoAgregarProductosDTO dto, @MappingTarget Pedido entity);
}

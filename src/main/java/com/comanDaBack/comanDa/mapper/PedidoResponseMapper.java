package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.PedidoMozoResponseDTO;
import com.comanDaBack.comanDa.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DetallePedidoResponseMapper.class})
public interface PedidoResponseMapper {

    @Mapping(source = "mesa.numMesa" , target = "numMesa")
    @Mapping(source = "estadoPedido", target="estadoPedido")
    @Mapping(source = "fechaHora", target = "fechaHora")
    @Mapping(source = "pedidos" , target = "detalles")
    @Mapping(source = "montoTotal" , target = "total")
    PedidoMozoResponseDTO toDTO(Pedido pedido);
}

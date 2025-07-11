package com.comanDaBack.comanDa.mapper;

import com.comanDaBack.comanDa.dto.DetallePedidoMozoDTO;
import com.comanDaBack.comanDa.entity.DetallePedido;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DetallePedidoResponseMapper {


    @Mapping(source = "menu.nombreMenu", target = "nombreMenu")
    DetallePedidoMozoDTO toDTO(DetallePedido detallePedido);

    @AfterMapping
    default void calcularSubtotal(DetallePedido detalle, @MappingTarget DetallePedidoMozoDTO dto) {
        dto.setSubTotal(detalle.getCantidad() * detalle.getMenu().getPrecio());
    }
}



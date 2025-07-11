package com.comanDaBack.comanDa.entity;

public enum EstadoPedido {
    CREADO,FACTURADO,CANCELADO,MODIFICADO, EN_PROCESO
}
//CREADO:pedido recién generado
//FACTURADO: pedido fue pagado y cerrado
//CANCELADO: pedido fue cancelado antes de entregarse
//MODIFICADO: pedido fue modificado por algún cambio o agregado
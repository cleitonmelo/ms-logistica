package br.com.techchalleng4.mslogistica.enums;

import lombok.Getter;

@Getter
public enum ShippingStatus {

    ORDER_RECEIVED("Pedido Recebido"),
    WITH_ORDER_CARRIER("Pedido com a Transpostadora"),
    DELIVERY_ROUTE("Pedido em Rota de Entrega"),
    ORDER_DELIVERED("Pedido Entregue");

    private String description;

    ShippingStatus(String status) {
        this.description = status;
    }

}

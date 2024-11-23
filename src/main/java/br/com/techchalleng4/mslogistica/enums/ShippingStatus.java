package br.com.techchalleng4.mslogistica.enums;

import lombok.Getter;

@Getter
public enum ShippingStatus {

    OrderReceived("Pedido Recebido"),
    WithOrderCarrier ("Pedido com a Transpostadora"),
    DeliveryRoute("Pedido em Rota de Entrega"),
    OrderDelivered("Pedido Entregue");

    private String description;

    ShippingStatus(String status) {
        this.description = status;
    }

}

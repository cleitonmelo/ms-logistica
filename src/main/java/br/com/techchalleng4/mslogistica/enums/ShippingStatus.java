package br.com.techchalleng4.mslogistica.enums;

public enum ShippingStatus {

    OrderReceived("Pedido Recebido");

    private String description;

    ShippingStatus(String status) {
        this.description = status;
    }

    public String getDescription() {
        return description;
    }
}

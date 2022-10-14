package com.project.store.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    // atributo que será associado com o valor do status
    private int code;

    // construtor que define o valor do código baseado no status
    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    // método que retorna um status baseado em um código
    public static OrderStatus valueOf(int code) {
        for(OrderStatus value: OrderStatus.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}

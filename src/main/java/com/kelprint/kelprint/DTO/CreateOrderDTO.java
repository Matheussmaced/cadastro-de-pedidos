package com.kelprint.kelprint.DTO;

public record CreateOrderDTO(
        String orderDescription, String totalValue, String valuePerUnit, String paymentType, String inputValue,
        Integer amount,
        String sizes, String kindOfFabric,
        String typeOfCollar, String deliveryDate, String comments,
        boolean finished) {
}

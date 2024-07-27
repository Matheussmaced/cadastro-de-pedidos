package com.kelprint.kelprint.DTO;

public record CreateOrderDTO(String orderDescription, int amount, String sizes, String kindOfFabric,
    String typeOfCollar, String comments, boolean finished) {
}

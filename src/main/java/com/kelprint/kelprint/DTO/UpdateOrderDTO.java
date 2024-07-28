package com.kelprint.kelprint.DTO;

public record UpdateOrderDTO(String orderDescription, Integer amount, String sizes, String kindOfFabric,
        String typeOfCollar, String comments, boolean finished) {
}
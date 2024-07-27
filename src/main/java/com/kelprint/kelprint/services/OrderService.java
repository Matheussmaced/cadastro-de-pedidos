package com.kelprint.kelprint.services;

import org.springframework.stereotype.Service;

import com.kelprint.kelprint.DTO.CreateOrderDTO;
import com.kelprint.kelprint.DTO.UpdateOrderDTO;
import com.kelprint.kelprint.entity.Order;

@Service
public interface OrderService {
  Order createOrder(String id, CreateOrderDTO createOrderDTO);

  Order updateOrder(String id, UpdateOrderDTO updateOrderDTO);

  void deleteOrder(String id);
}

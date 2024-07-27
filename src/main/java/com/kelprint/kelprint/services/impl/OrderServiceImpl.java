package com.kelprint.kelprint.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kelprint.kelprint.DTO.CreateOrderDTO;
import com.kelprint.kelprint.DTO.UpdateOrderDTO;
import com.kelprint.kelprint.entity.Client;
import com.kelprint.kelprint.entity.Order;
import com.kelprint.kelprint.repository.ClientRepository;
import com.kelprint.kelprint.repository.OrderRepository;
import com.kelprint.kelprint.services.OrderService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderServiceImpl implements OrderService {
  private final ClientRepository clientRepository;
  private final OrderRepository orderRepository;

  public OrderServiceImpl(ClientRepository clientRepository, OrderRepository orderRepository) {
    this.clientRepository = clientRepository;
    this.orderRepository = orderRepository;
  }

  @Override
  public Order createOrder(String id, CreateOrderDTO createOrderDTO) {
    var clientId = UUID.fromString(id);

    Client client = clientRepository.findById(clientId)
        .orElseThrow(() -> new EntityNotFoundException("Client not found"));

    Order order = new Order();

    order.setOrderDescription(createOrderDTO.orderDescription());
    order.setAmount(createOrderDTO.amount());
    order.setSizes(createOrderDTO.sizes());
    order.setKindOfFabric(createOrderDTO.kindOfFabric());
    order.setComments(createOrderDTO.comments());
    order.setFinished(createOrderDTO.finished());
    order.setClient(client);

    return orderRepository.save(order);

  }

  @Override
  public Order updateOrder(String id, UpdateOrderDTO updateOrderDTO) {
    return null;
  }

  @Override
  public void deleteOrder(String id) {

  }

}

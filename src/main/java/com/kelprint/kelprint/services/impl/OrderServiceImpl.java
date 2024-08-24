package com.kelprint.kelprint.services.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
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
  public Order getOrder(String id) {
    var orderId = UUID.fromString(id);

    return orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Order not found"));
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
    order.setDeliveryDate(createOrderDTO.deliveryDate());
    order.setTypeOfCollar(createOrderDTO.typeOfCollar());
    order.setClient(client);

    return orderRepository.save(order);

  }

  @Override
  public Order updateOrder(String id, UpdateOrderDTO updateOrderDTO) {
    var orderId = UUID.fromString(id);

    Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new EntityNotFoundException("Order not found"));

    if (updateOrderDTO.orderDescription() != null) {
      order.setOrderDescription(updateOrderDTO.orderDescription());
    }
    if (updateOrderDTO.amount() != null) {
      order.setAmount(updateOrderDTO.amount());
    }
    if (updateOrderDTO.sizes() != null) {
      order.setSizes(updateOrderDTO.sizes());
    }
    if (updateOrderDTO.kindOfFabric() != null) {
      order.setKindOfFabric(updateOrderDTO.kindOfFabric());
    }
    if (updateOrderDTO.comments() != null) {
      order.setComments(updateOrderDTO.comments());
    }
    if (updateOrderDTO.finished() == false || updateOrderDTO.finished() == true) {
      order.setFinished(updateOrderDTO.finished());
    }
    if (updateOrderDTO.typeOfCollar() != null) {
      order.setTypeOfCollar(updateOrderDTO.typeOfCollar());
    }
    if (updateOrderDTO.deliveryDate() != null) {
      order.setDeliveryDate(updateOrderDTO.deliveryDate());
    }

    return orderRepository.save(order);

  }

  @Override
  public void deleteOrder(String id) {
    var orderId = UUID.fromString(id);

    Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new EntityNotFoundException("Order not found"));

    orderRepository.delete(order);
  }

}

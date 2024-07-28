package com.kelprint.kelprint.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kelprint.kelprint.DTO.CreateOrderDTO;
import com.kelprint.kelprint.DTO.UpdateOrderDTO;
import com.kelprint.kelprint.entity.Order;
import com.kelprint.kelprint.services.OrderService;

@Controller
@RequestMapping("/client")
public class OrderController {
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("/{id}/order")
  public ResponseEntity<Order> createOrder(@PathVariable("id") String id, @RequestBody CreateOrderDTO createOrderDTO) {
    var createOrder = orderService.createOrder(id, createOrderDTO);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(createOrder.getId()).toUri();

    return ResponseEntity.created(location).body(createOrder);
  }

  @PutMapping("/{id}/order")
  public ResponseEntity<Void> updateOrder(@PathVariable("id") String id,
      @RequestBody UpdateOrderDTO updateOrderDTO) {
    orderService.updateOrder(id, updateOrderDTO);

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}/order")
  public ResponseEntity<Void> deleteOrder(@PathVariable("id") String id) {
    orderService.deleteOrder(id);

    return ResponseEntity.noContent().build();
  }

}

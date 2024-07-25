package com.kelprint.kelprint.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kelprint.kelprint.entity.Client;
import com.kelprint.kelprint.services.ClientService;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping
  public ResponseEntity<List<Client>> findAll() {
    var clients = clientService.findAll();

    return ResponseEntity.ok(clients);
  }
}

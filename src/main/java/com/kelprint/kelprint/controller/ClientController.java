package com.kelprint.kelprint.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kelprint.kelprint.DTO.CreateClientDTO;
import com.kelprint.kelprint.DTO.UpdateClientDTO;
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

  @GetMapping("/{id}")
  public ResponseEntity<Client> findById(@PathVariable("id") String id) {
    var client = clientService.findById(id);

    return ResponseEntity.ok(client);
  }

  @PostMapping
  public ResponseEntity<Client> createClient(@RequestBody CreateClientDTO createClientDTO) {
    var createClient = clientService.create(createClientDTO);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(createClient.getClientId()).toUri();

    return ResponseEntity.created(location).body(createClient);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable String id) {
    clientService.delete(id);

    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateClient(@PathVariable("id") String id,
      @RequestBody UpdateClientDTO updateClientDTO) {

    clientService.updateClient(id, updateClientDTO);

    return ResponseEntity.noContent().build();
  }
}

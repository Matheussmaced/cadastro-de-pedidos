package com.kelprint.kelprint.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kelprint.kelprint.DTO.CreateClientDTO;
import com.kelprint.kelprint.DTO.UpdateClientDTO;
import com.kelprint.kelprint.entity.Client;
import com.kelprint.kelprint.repository.ClientRepository;
import com.kelprint.kelprint.services.ClientService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientServiceImpl implements ClientService {
  private final ClientRepository clientRepository;

  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public List<Client> findAll() {
    List<Client> clients = clientRepository.findAll();
    if (clients != null) {
      return clients;
    } else {
      return List.of();
    }
  }

  @Override
  public Client findById(String id) {
    return null;
  }

  @Override
  public Client create(CreateClientDTO createClientDTO) {
    Client client = new Client();
    client.setName(createClientDTO.name());
    client.setNumber(createClientDTO.number());

    return clientRepository.save(client);
  }

  @Override
  public void delete(String id) {
    var clientId = UUID.fromString(id);
    Client clientToDelete;

    clientToDelete = clientRepository.findById(clientId)
        .orElseThrow(() -> new EntityNotFoundException("Client not found"));

    clientRepository.delete(clientToDelete);

  }

  @Override
  public Client updateClient(String id, UpdateClientDTO updateClientDTO) {
    var clientId = UUID.fromString(id);
    Client clientUpdate;

    clientUpdate = clientRepository.findById(clientId)
        .orElseThrow(() -> new EntityNotFoundException("Client not found"));

    if (updateClientDTO.name() != null) {
      clientUpdate.setName(updateClientDTO.name());
    }
    if (updateClientDTO.number() != null) {
      clientUpdate.setNumber(updateClientDTO.number());
    }

    return clientRepository.save(clientUpdate);
  }

}

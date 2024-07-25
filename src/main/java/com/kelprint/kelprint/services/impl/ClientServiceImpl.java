package com.kelprint.kelprint.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kelprint.kelprint.DTO.UpdateClientDTO;
import com.kelprint.kelprint.entity.Client;
import com.kelprint.kelprint.repository.ClientRepository;
import com.kelprint.kelprint.services.ClientService;

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
  public void delete(String id) {

  }

  @Override
  public Client updateClient(String id, UpdateClientDTO updateClientDTO) {
    return null;
  }
}

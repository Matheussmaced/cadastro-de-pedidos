package com.kelprint.kelprint.services;

import java.util.List;

import com.kelprint.kelprint.DTO.UpdateClientDTO;
import com.kelprint.kelprint.entity.Client;

public interface ClientService {
  Client findById(String id);

  List<Client> findAll();

  void delete(String id);

  Client updateClient(String id, UpdateClientDTO updateClientDTO);
}
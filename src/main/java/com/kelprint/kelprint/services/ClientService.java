package com.kelprint.kelprint.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kelprint.kelprint.DTO.CreateClientDTO;
import com.kelprint.kelprint.DTO.UpdateClientDTO;
import com.kelprint.kelprint.entity.Client;

@Service
public interface ClientService {
  Client findById(String id);

  List<Client> findAll();

  Client create(CreateClientDTO createClientDTO);

  void delete(String id);

  Client updateClient(String id, UpdateClientDTO updateClientDTO);
}
package com.kelprint.kelprint.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelprint.kelprint.entity.Client;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
  List<Client> findAllByOrderByCreationTimestampAsc();
}

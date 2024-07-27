package com.kelprint.kelprint.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kelprint.kelprint.entity.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}

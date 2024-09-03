package com.kelprint.kelprint.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.Instant;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_clients")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID clientId;

  @Column(name = "name")
  String name;

  @Column(name = "number")
  String number;

  @Column(name = "danger")
  private Boolean danger;

  @CreationTimestamp
  private Instant creationTimestamp;

  @UpdateTimestamp
  private Instant updateTimestamp;

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<Order> order;

  public Client() {
  }

  public Client(UUID clientId, String name, String number, Boolean danger, Instant creationTimestamp,
      Instant updateTimestamp, List<Order> order) {
    this.clientId = clientId;
    this.name = name;
    this.number = number;
    this.danger = danger;
    this.creationTimestamp = creationTimestamp;
    this.updateTimestamp = updateTimestamp;
    this.order = order;
  }

  public UUID getClientId() {
    return clientId;
  }

  public void setClientId(UUID clientId) {
    this.clientId = clientId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Instant getCreationTimestamp() {
    return creationTimestamp;
  }

  public void setCreationTimestamp(Instant creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
  }

  public Instant getUpdateTimestamp() {
    return updateTimestamp;
  }

  public void setUpdateTimestamp(Instant updateTimestamp) {
    this.updateTimestamp = updateTimestamp;
  }

  public List<Order> getOrder() {
    return order;
  }

  public void setOrder(List<Order> order) {
    this.order = order;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Boolean getDanger() {
    return danger;
  }

  public void setDanger(Boolean danger) {
    this.danger = danger;
  }

}

package com.kelprint.kelprint.entity;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_order")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "client_id")
  @JsonBackReference
  private Client client;

  @Column(name = "order_description")
  private String orderDescription;

  @Column(name = "amount")
  private Integer amount;

  @Column(name = "sizes")
  private String sizes;

  @Column(name = "kind_of_fabric")
  private String kindOfFabric;

  @Column(name = "type_of_collar")
  private String typeOfCollar;

  @Column(name = "comments")
  private String comments;

  @Column(name = "delivery_date")
  private String deliveryDate;

  @Column(name = "finished")
  private boolean finished;

  @CreationTimestamp
  private Instant creationTimestamp;

  @UpdateTimestamp
  private Instant updateTimestamp;

  public Order() {
  }

  public Order(UUID id, Client client, String orderDescription, Integer amount, String sizes, String kindOfFabric,
      String typeOfCollar, String comments, String deliveryDate, boolean finished, Instant creationTimestamp,
      Instant updateTimestamp) {
    this.id = id;
    this.client = client;
    this.orderDescription = orderDescription;
    this.amount = amount;
    this.sizes = sizes;
    this.kindOfFabric = kindOfFabric;
    this.typeOfCollar = typeOfCollar;
    this.comments = comments;
    this.deliveryDate = deliveryDate;
    this.finished = finished;
    this.creationTimestamp = creationTimestamp;
    this.updateTimestamp = updateTimestamp;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public String getOrderDescription() {
    return orderDescription;
  }

  public void setOrderDescription(String orderDescription) {
    this.orderDescription = orderDescription;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public String getSizes() {
    return sizes;
  }

  public void setSizes(String sizes) {
    this.sizes = sizes;
  }

  public String getKindOfFabric() {
    return kindOfFabric;
  }

  public void setKindOfFabric(String kindOfFabric) {
    this.kindOfFabric = kindOfFabric;
  }

  public String getTypeOfCollar() {
    return typeOfCollar;
  }

  public void setTypeOfCollar(String typeOfCollar) {
    this.typeOfCollar = typeOfCollar;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(String deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public boolean isFinished() {
    return finished;
  }

  public void setFinished(boolean finished) {
    this.finished = finished;
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

}

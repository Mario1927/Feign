package com.back.actividad01.model;

import javax.persistence.*;

public class Sales {
  
  @Id
  @GeneratedValue
  @Column(nullable = false, updatable = false)
  private Integer id;

  private String customerName;

  private Double ammount;

  public Sales(String customerName, Double ammount) {
    this.customerName = customerName;
    this.ammount = ammount;
  }

  public Integer getSalesId() { return this.id; }

  public void setSalesId(Integer id) { this.id = id; }

  public String getSalesCustomerName() { return this.customerName; }

  public void setSalesCustomerName(String name) { this.customerName = name; }

  public Double getSalesAmmount() { return this.ammount; }

  public void setSalesAmmount(Double ammount) { this.ammount = ammount; }

}

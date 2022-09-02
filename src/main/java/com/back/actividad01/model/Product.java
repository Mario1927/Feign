package com.back.actividad01.model;

import javax.persistence.*;

@Entity
public class Product {
  
  @Id
  @GeneratedValue
  @Column(nullable = false, updatable = false)
  private Integer id;

  private String name;

  private String type;
  
  private String brand;

  private Double price;

  public Product() {}

  public Product(String name, String type, String brand, Double price) {
    this.name = name;
    this.type = type;
    this.brand = brand;
    this.price = price;
  }

  public Integer getProductId() { return this.id; }

  public void setProductId(Integer idProduct ) { this.id = idProduct; }

  public String getProductName() { return this.name; }

  public void setProductName(String name) { this.name = name; }

  public String getProductType() { return this.type; }

  public void setProductType(String type) { this.type = type; }

  public String getProductBrand() { return this.brand; }

  public void setProductBrand(String brand) { this.brand = brand; }

  public Double getProductPrice() { return this.price; }

  public void setProductPrice(Double price) { this.price = price; }

}

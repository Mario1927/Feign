package com.back.actividad01.model;

import javax.persistence.*;

@Entity
public class Category {
  
  @Id
  @GeneratedValue
  @Column(nullable = false, updatable = false)
  private Integer id;

  private String name;

  private String description;

  public Category() {}

  Category(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Integer getIdCategory() { return this.id; }

  public void setIdCategory(Integer idCategory) { this.id = idCategory; }

  public String getCategoryName() { return this.name; }

  public void setCategoryName(String name) { this.name = name; }

  public String getCategoryDescription() { return this.description; }

  public void setCategoryDescription(String description) { this.description = description; }
}

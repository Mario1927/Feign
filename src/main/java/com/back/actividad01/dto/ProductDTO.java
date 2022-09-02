package com.back.actividad01.dto;

import com.back.actividad01.model.Category;

import lombok.Data;

@Data
public class ProductDTO {
  Integer id;
  String name;
  String type;
  String brand;
  Double price;
}

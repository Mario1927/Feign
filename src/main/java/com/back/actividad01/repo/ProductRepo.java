package com.back.actividad01.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.actividad01.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

  List<Product> findByName(String name);

  List<Product> findByType(String type);

  List<Product> findByBrand(String brand);

  List<Product> findByTypeAndBrand(String type, String brand);
}

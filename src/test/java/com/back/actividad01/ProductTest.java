package com.back.actividad01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.back.actividad01.model.Product;
import com.back.actividad01.repo.ProductRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductTest {

  @Autowired
  ProductRepo productRepo;

  @BeforeEach
  void init() {

    productRepo.deleteAll();

    Product newProduct = new Product();
    newProduct.setProductName("Latitude 4500");

    productRepo.save(newProduct);
  }

  @Test
  void findAllProductTest() {

    List<Product> products = productRepo.findAll();

    assertEquals(1, products.size());
  }

  @Test
  void findById() {

    Integer productId = productRepo.findAll().get(0).getProductId();
 
    Optional<Product> product = productRepo.findById(productId);
 
    assertTrue(product.isPresent());
    assertEquals(productId, product.get().getProductId());
  }

  @Test
  void findProductByName() {

    List<Product> products = productRepo.findByName("Latitude 4500");

    assertEquals(1, products.size());
  }

  @Test
  void updateProduct() {

    Integer productId = productRepo.findAll().get(0).getProductId();

    Optional<Product> product = productRepo.findById(productId);

    String newName = "Updated";

    product.get().setProductName(newName);

    productRepo.save(product.get());

    product = productRepo.findById(productId);

    assertEquals(newName, product.get().getProductName());
  }

  @Test
  void deleteProductById() {

   Integer productId = productRepo.findAll().get(0).getProductId();

   productRepo.deleteById(productId);

   Optional<Product> product = productRepo.findById(productId);

   assertFalse(product.isPresent());
  }
}

package com.back.actividad01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.actividad01.exception.Exception;
import com.back.actividad01.model.Product;
import com.back.actividad01.repo.ProductRepo;

import java.util.List;

@Service
public class ProductService {
  private final ProductRepo productRepo;

  @Autowired
  public ProductService(ProductRepo productRepo) { this.productRepo = productRepo; }

  public Product addProduct(Product product) { return productRepo.save(product); }

  public Product updateProductById(Integer id, Product product) throws Exception { 

    Product oldProduct = productRepo.findById(id).orElseThrow(() -> new Exception("Product not found for id " + id));

    oldProduct.setProductName(product.getProductName());
    oldProduct.setProductBrand(product.getProductBrand());
    oldProduct.setProductType(product.getProductType());
    oldProduct.setProductPrice(product.getProductPrice());

    return productRepo.save(oldProduct);

  }

  public void deleteProductById(Integer id) { productRepo.deleteById(id); }

  public List<Product> getAllProducts() { return productRepo.findAll(); }

  public Product getProductById(Integer id) { return productRepo.findById(id).orElseThrow(() -> new Exception("Product not found for id " + id)); }

  public List<Product> getProductsByName(String name) { return productRepo.findByName(name); }

  public List<Product> getProductsByType(String type) { return productRepo.findByType(type); }

  public List<Product> getProductsByBrand(String brand) { return productRepo.findByBrand(brand); }

  public List<Product> getProductsByTypeAndBrand(String type, String brand) { return productRepo.findByTypeAndBrand(type, brand); }
  
}

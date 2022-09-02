package com.back.actividad01.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.back.actividad01.converter.ProductConverter;
import com.back.actividad01.dto.ProductDTO;
import com.back.actividad01.model.Product;
import com.back.actividad01.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
  
  private final ProductService productService;
  private final ProductConverter productConverter;

  ProductController(ProductService productService, ProductConverter productConverter) { 
    
    this.productService = productService; 

    this.productConverter = productConverter; 
  }

  public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name) {
    List<Product> products = productService.getProductsByName(name);
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  public ResponseEntity<List<Product>> getProductsByType(@PathVariable String type) {
    List<Product> products = productService.getProductsByType(type);
    return new ResponseEntity<>(products, HttpStatus.OK);
  }
  
  public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String brand) {
    List<Product> products = productService.getProductsByBrand(brand);
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  public ResponseEntity<List<Product>> getProductsByTypeAndBrand(@RequestParam String type, @RequestParam String brand) {
    List<Product> products = productService.getProductsByTypeAndBrand(type, brand);
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Product>> getProducts() {
    List<Product> products = productService.getAllProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
    Product product = productService.getProductById(id);
    return new ResponseEntity<>(product, HttpStatus.OK);
  }
  
  @GetMapping("/search")
  public ResponseEntity<List<Product>> searchController(@RequestParam(required = false) String type, @RequestParam(required = false) String brand, @RequestParam(required = false) String name) {

    if(name != null) { return getProductsByName(name); }
    if(type != null && brand != null) { return getProductsByTypeAndBrand(type, brand); }
    if(type != null) { return getProductsByType(type); }
    if(brand != null) { return getProductsByBrand(brand); }

    return new ResponseEntity<>(HttpStatus.OK) ;
  }

  @PostMapping
  public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {
    
    Product newProduct = productConverter.dtoToEntity(productDTO);

    return new ResponseEntity<>(productService.addProduct(newProduct), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProductById(@PathVariable Integer id) {
    productService.deleteProductById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProductById(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
    Product newProduct = productConverter.dtoToEntity(productDTO);
    return new ResponseEntity<>(productService.updateProductById(id, newProduct), HttpStatus.OK);
  }

}

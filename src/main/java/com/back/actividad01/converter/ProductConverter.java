package com.back.actividad01.converter;

import org.springframework.stereotype.Component;

import com.back.actividad01.dto.ProductDTO;
import com.back.actividad01.model.Product;

@Component
public class ProductConverter {
  
  public Product dtoToEntity(ProductDTO productDTO) {
    
    Product product = new Product();
    
    product.setProductId(productDTO.getId());
    product.setProductName(productDTO.getName());
    product.setProductType(productDTO.getType());
    product.setProductBrand(productDTO.getBrand());
    product.setProductPrice(productDTO.getPrice());

    return product;
  }
}

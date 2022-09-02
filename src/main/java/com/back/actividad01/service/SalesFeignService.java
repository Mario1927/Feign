package com.back.actividad01.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.back.actividad01.model.Product;


@FeignClient(name = "product", url = "${remote.service.url}")
public interface SalesFeignService {
  
  @GetMapping("/product")
  List<Product> getProducts();
  
}

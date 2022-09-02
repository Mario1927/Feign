package com.back.actividad01.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.back.actividad01.model.Product;
import com.back.actividad01.service.SalesFeignService;

@Controller
@RequestMapping("/sales")
public class SalesFeignController {
  
  private SalesFeignService salesFeignService;

  public SalesFeignController(SalesFeignService salesFeignService) { this.salesFeignService = salesFeignService; }

  @GetMapping
  public ResponseEntity<List<Product>> getProducts() {
    return new ResponseEntity<>(this.salesFeignService.getProducts(), HttpStatus.OK);
  }
  
}

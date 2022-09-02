package com.back.actividad01.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.back.actividad01.converter.CategoryConverter;
import com.back.actividad01.dto.CategoryDTO;
import com.back.actividad01.model.Category;
import com.back.actividad01.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
  
  private CategoryService categoryService;
  private CategoryConverter categoryConverter;

  public CategoryController(CategoryService categoryService, CategoryConverter categoryConverter) { 
    this.categoryService = categoryService; 
    this.categoryConverter = categoryConverter;
  }

  @GetMapping
  public ResponseEntity<List<Category>> getCategories() {
    List<Category> categories = categoryService.getAllCategories();
    return new ResponseEntity<>(categories, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
    Category category = categoryService.getCategoryById(id);
    return new ResponseEntity<>(category, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO categoryDTO) {
    
    Category category = categoryConverter.dtoToEntity(categoryDTO);
    
    return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCategoryById(@PathVariable Integer id) {
    categoryService.deleteProductById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Category> updateProductById(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO) {
    Category newProduct = categoryConverter.dtoToEntity(categoryDTO);
    return new ResponseEntity<>(categoryService.updateCategoryById(id, newProduct), HttpStatus.OK);
  }

}

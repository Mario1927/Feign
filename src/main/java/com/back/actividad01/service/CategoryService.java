package com.back.actividad01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.actividad01.exception.Exception;
import com.back.actividad01.model.Category;
import com.back.actividad01.repo.CategoryRepo;

@Service
public class CategoryService {
  private CategoryRepo categoryRepo;

  @Autowired
  public CategoryService(CategoryRepo categoryRepo) { this.categoryRepo = categoryRepo; }

  public Category addCategory(Category category) { return this.categoryRepo.save(category); }

  public Category updateCategoryById(Integer id, Category category) {  
    
    Category oldCategory = categoryRepo.findById(id).orElseThrow(() -> new Exception("Category not found for id " + id));

    oldCategory.setCategoryName(category.getCategoryName());
    oldCategory.setCategoryDescription(category.getCategoryDescription());

    return categoryRepo.save(oldCategory);
  }

  public void deleteProductById(Integer id) { categoryRepo.deleteById(id); }

  public List<Category> getAllCategories() { return this.categoryRepo.findAll(); }

  public Category getCategoryById(Integer id) { return this.categoryRepo.findById(id).orElseThrow(() -> new Exception("Category not found for id " + id)); }
}

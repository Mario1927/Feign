package com.back.actividad01.converter;

import org.springframework.stereotype.Component;

import com.back.actividad01.dto.CategoryDTO;
import com.back.actividad01.model.Category;

@Component
public class CategoryConverter {
  
  public Category dtoToEntity(CategoryDTO categoryDTO) {
    
    Category category = new Category();
    
    category.setIdCategory(categoryDTO.getId());
    category.setCategoryName(categoryDTO.getName());
    category.setCategoryDescription(categoryDTO.getDescription());

    return category;
  }
}

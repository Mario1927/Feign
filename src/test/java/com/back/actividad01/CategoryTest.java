package com.back.actividad01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.back.actividad01.model.Category;
import com.back.actividad01.repo.CategoryRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryTest {
  
  @Autowired
  CategoryRepo categoryRepo;

  @BeforeEach
  void init() {
    categoryRepo.deleteAll();

    Category newCategory = new Category();
    newCategory.setCategoryName("Laptop");

    categoryRepo.save(newCategory);
  }

  @Test
  void findAllCategories() {

    List<Category> categories = categoryRepo.findAll();

    assertEquals(1, categories.size());
  }

  @Test
  void findById() {

    Integer categoryId = categoryRepo.findAll().get(0).getIdCategory();
 
    Optional<Category> category = categoryRepo.findById(categoryId);
 
    assertTrue(category.isPresent());
    assertEquals(categoryId, category.get().getIdCategory());
  }

  @Test
  void updateCategory() {

    Integer categoryId = categoryRepo.findAll().get(0).getIdCategory();

    Optional<Category> category = categoryRepo.findById(categoryId);

    String newName = "Updated";

    category.get().setCategoryName(newName);

    categoryRepo.save(category.get());

    category = categoryRepo.findById(categoryId);

    assertEquals(newName, category.get().getCategoryName());
  }

  @Test
  void deleteCategoryById() {

   Integer categoryId = categoryRepo.findAll().get(0).getIdCategory();

   categoryRepo.deleteById(categoryId);

   Optional<Category> category = categoryRepo.findById(categoryId);

   assertFalse(category.isPresent());
  }
}

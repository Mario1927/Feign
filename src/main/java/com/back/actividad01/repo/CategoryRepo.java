package com.back.actividad01.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.actividad01.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
  
  List<Category> findByName(String name);

}

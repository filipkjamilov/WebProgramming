package com.example.emt.service;

import com.example.emt.models.Category;
import com.example.emt.models.exceptions.CategoryNotFound;

import java.util.List;

public interface CategoryService {
    void deleteAll();
    List<Category> findAll();
    Category findById(Long categoryId) throws CategoryNotFound;
    Category save(Category category);
}

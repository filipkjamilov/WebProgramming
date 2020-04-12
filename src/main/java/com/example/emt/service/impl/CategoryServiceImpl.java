package com.example.emt.service.impl;

import com.example.emt.models.Category;
import com.example.emt.models.exceptions.CategoryNotFound;
import com.example.emt.repository.CategoriesRepository;
import com.example.emt.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoriesRepository categoriesRepository;

    public CategoryServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }


    @Override
    public void deleteAll() {
        categoriesRepository.deleteAll();
    }

    @Override
    public List<Category> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Category findById(Long categoryId) throws CategoryNotFound {
        return this.categoriesRepository.findById(categoryId).orElseThrow(CategoryNotFound::new);
    }

    @Override
    public Category save(Category category) {
        return categoriesRepository.save(category);
    }
}

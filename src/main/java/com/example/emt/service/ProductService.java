package com.example.emt.service;

import com.example.emt.models.Product;
import com.example.emt.models.exceptions.CategoryNotFound;
import com.example.emt.models.exceptions.ManufacturerNotFoundException;
import com.example.emt.models.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService  {

    Product findById(Long productId) throws ProductNotFoundException;
    Product save(Product product);
    List<Product> findAll();
    void deleteAll();

    List<Product> findByCategoryId(Long categoryId) throws CategoryNotFound;

    List<Product> findByCategoryIdAndManufacturerId(Long categoryId, Long manufacturerId) throws CategoryNotFound, ManufacturerNotFoundException;

    Long getPriceByCategory(Long categoryId) throws CategoryNotFound;

    void deleteById(Long id);

    List<Product> findPagination(Pageable pageable);

    Product update(Long id, Product product) throws ProductNotFoundException;
}

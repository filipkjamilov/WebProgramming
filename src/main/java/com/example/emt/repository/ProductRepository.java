package com.example.emt.repository;

import com.example.emt.models.Category;
import com.example.emt.models.Manufacturer;
import com.example.emt.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category cat);
    List<Product> findAllByCategoryAndManufacturer(Category cat, Manufacturer man);

}

package com.example.emt.service.impl;

import com.example.emt.models.Category;
import com.example.emt.models.Manufacturer;
import com.example.emt.models.Product;
import com.example.emt.models.exceptions.CategoryNotFound;
import com.example.emt.models.exceptions.ManufacturerNotFoundException;
import com.example.emt.models.exceptions.ProductNotFoundException;
import com.example.emt.repository.ProductRepository;
import com.example.emt.service.CategoryService;
import com.example.emt.service.ManufacturerService;
import com.example.emt.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ManufacturerService manufacturerService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ManufacturerService manufacturerService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }


    @Override
    public Product findById(Long productId) throws ProductNotFoundException {
        return productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }


    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Override
    public List<Product> findByCategoryId(Long categoryId) throws CategoryNotFound {
        Category c = categoryService.findById(categoryId);
        return productRepository.findAllByCategory(c);
    }

    @Override
    public List<Product> findByCategoryIdAndManufacturerId(Long categoryId, Long manufacturerId) throws CategoryNotFound, ManufacturerNotFoundException {
        Category c = categoryService.findById(categoryId);
        Manufacturer m = manufacturerService.findById(manufacturerId);

        return productRepository.findAllByCategoryAndManufacturer(c,m);
    }

    @Override
    public Long getPriceByCategory(Long categoryId) throws CategoryNotFound {
        Category c = categoryService.findById(categoryId);
        List<Product> products= productRepository.findAllByCategory(c);
        Long price=0L;

        for (Product p: products) {
            price+=p.getPrice();
        }

        return price;
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findPagination(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }

    @Override
    public Product update(Long id, Product product){

            productRepository.deleteById(id);
            return productRepository.save(product);


    }


}

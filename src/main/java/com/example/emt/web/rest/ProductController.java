package com.example.emt.web.rest;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/rest/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ManufacturerService manufacturerService;

    public ProductController(ProductRepository productRepository, ProductService productService, CategoryService categoryService, ManufacturerService manufacturerService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }


    @GetMapping(params = {"page", "size"})
    public List<Product> findAllPaginated(@RequestParam("page") int page, @RequestParam("size") int size){

        return productService.findPagination(new PageRequest(page==0 ? 0 : page-1, size));

    }

    //Return Size
    @GetMapping("/size")
    public int getSizeOfAllProducts(){

        return productService.findAll().size();
    }
    //Return all products
    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }
    @GetMapping("/categories")
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }
    @GetMapping("/manufacturers")
    public List<Manufacturer> findAllManufactuters() {
        return manufacturerService.findAll();
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.findById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> findAllByCategory(@PathVariable Long categoryId) throws CategoryNotFound {
        return productService.findByCategoryId(categoryId);
    }
    @GetMapping("/category/{categoryId}/manufacturer/{manufacturerId}")
    public List<Product> returnAllProductsWithManAndCat(@PathVariable Long categoryId, @PathVariable Long manufacturerId) throws CategoryNotFound, ManufacturerNotFoundException {
        return productService.findByCategoryIdAndManufacturerId(categoryId, manufacturerId);
    }
    @GetMapping("/category/{categoryId}/price")
    public Long returnPrice(@PathVariable Long categoryId) throws CategoryNotFound {

        return productService.getPriceByCategory(categoryId);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
            return productService.save(product);
    }

    @PostMapping("/addmanufacturer")
    public Manufacturer addManufacturer(@RequestBody Manufacturer manufacturer){
        System.out.println(manufacturer.getName());
        return manufacturerService.save(manufacturer);
    }
    @PostMapping("/addcategory")
    public Category addCategoty(@RequestBody Category category){
        return categoryService.save(category);
    }

    @PostMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) throws ProductNotFoundException {

        return productService.update(id, product);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        this.productService.deleteById(id);
    }
}

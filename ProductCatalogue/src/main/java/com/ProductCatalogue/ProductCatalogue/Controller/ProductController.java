package com.ProductCatalogue.ProductCatalogue.Controller;

import com.ProductCatalogue.ProductCatalogue.Model.Product;
import com.ProductCatalogue.ProductCatalogue.Model.Rating;
import com.ProductCatalogue.ProductCatalogue.Repository.ProductRepository;
import com.ProductCatalogue.ProductCatalogue.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Retrieve all products with pagination and sorting
    @GetMapping
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    // Retrieve a product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }

    // Create a product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Update a product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        product.setId(id); // Set the ID from the path variable
        return productRepository.save(product);
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
    }

    // Search products by name
    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam("name") String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    // Rate a product
    @PostMapping("/{id}/rate")
    public Product rateProduct(@PathVariable String id, @RequestBody Rating rating) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.addRating(rating);
            return productRepository.save(product);
        } else {
            // Handle product not found
            return null;
        }
    }
}

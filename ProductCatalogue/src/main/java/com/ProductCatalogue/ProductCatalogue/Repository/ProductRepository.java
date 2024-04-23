package com.ProductCatalogue.ProductCatalogue.Repository;

import com.ProductCatalogue.ProductCatalogue.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByNameContainingIgnoreCase(String name);
}

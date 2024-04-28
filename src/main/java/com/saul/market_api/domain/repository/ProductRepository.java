package com.saul.market_api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.saul.market_api.domain.Product;

public interface ProductRepository {

    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarceProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
    
}

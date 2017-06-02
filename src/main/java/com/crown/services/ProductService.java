package com.crown.services;

import com.crown.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);
    void deleteProductById(int id);
}

package com.crown.dao;

import com.crown.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void addProduct(Product product);
    void deleteProduct(int id);
}

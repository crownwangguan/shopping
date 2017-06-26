package com.crown.services;

import com.crown.dao.ProductDAO;
import com.crown.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Override
    public Product addProduct(Product product) {
        List<Product> products = productDAO.getAllProducts();
        for(Product iterProduct : products) {
            if(iterProduct.getName().equals(product.getName())) {
                return iterProduct;
            }
        }
        productDAO.addProduct(product);
        return product;
    }

    @Override
    public void deleteProductById(int id) {
        productDAO.deleteProduct(id);
    }
}

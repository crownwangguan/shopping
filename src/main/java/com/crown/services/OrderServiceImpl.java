package com.crown.services;

import com.crown.dao.ProductDAO;
import com.crown.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public void processOrder(int productId, int quantity) {
        Product product = productDAO.getProductById(productId);
        if (product.getUnitsInStock() < quantity && product.getUnitsInStock() <= 0) {
            throw new IllegalArgumentException("Out of stock. Available units in stock is "+ product.getUnitsInStock());
        }
        product.setUnitsInStock(product.getUnitsInStock()-quantity);
    }
}

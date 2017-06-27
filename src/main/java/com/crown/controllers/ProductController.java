package com.crown.controllers;

import com.crown.model.Product;
import com.crown.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> allProducts() {
        List<Product> products = productService.getAllProducts();
        if(products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> addNewProduct(@ModelAttribute Product product) {
        Product newProduct = productService.addProduct(product);
        if(newProduct.equals(product)) {
            return new ResponseEntity<>(Collections.singletonMap("message", "Successfully created."), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(Collections.singletonMap("message", "Already exists."), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> deleteProductById(@PathVariable("id") int productId){
        System.out.println(productId);
        Product product = productService.getProductById(productId);
        if (product == null) {
            System.out.println("Unable to delete. Product with id " + productId + " not found");
            return new ResponseEntity<>(Collections.singletonMap("message", "Content not found!"), HttpStatus.NOT_FOUND);
        }
        productService.deleteProductById(productId);
        return new ResponseEntity<>(Collections.singletonMap("message", "Successfully deleted."), HttpStatus.OK);
    }
}

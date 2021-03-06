package com.crown.controllers;

import com.crown.model.Product;
import com.crown.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public String allProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model){
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result){
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "addProduct";
        } else {
            productService.addProduct(newProduct);
            return "redirect:/products";
        }
    }

    @RequestMapping("/delete")
    public String deleteProductById(@RequestParam("id") String productId){
        productService.deleteProductById(Integer.parseInt(productId));
        return "redirect:/products";
    }
}

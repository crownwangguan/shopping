package com.crown.controllers;

import com.crown.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    @Autowired
	private OrderService orderService;

    @RequestMapping("/products/order")
    public String process(@RequestParam("id") String productId, @RequestParam("quality") int quality){
        try {
            orderService.processOrder(Integer.parseInt(productId), quality);
        } catch (Exception e) {
            return "redirect:/products";
        }
        return "redirect:/products";
    }
}

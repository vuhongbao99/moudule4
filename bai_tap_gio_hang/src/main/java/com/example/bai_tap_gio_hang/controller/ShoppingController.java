package com.example.bai_tap_gio_hang.controller;

import com.example.bai_tap_gio_hang.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/candy-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("views/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
}

package com.example.bai_tap1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @PostMapping("/convert")
    public String convert(@RequestParam("usd") double usdAmount,
                          @RequestParam("rate") double exchangeRate,
                          Model model) {

        // Chỉ cần 3 dòng code để tính toán
        double vndAmount = usdAmount * exchangeRate;

        // Gửi kết quả sang JSP
        model.addAttribute("usdAmount", usdAmount);
        model.addAttribute("exchangeRate", exchangeRate);
        model.addAttribute("vndAmount", vndAmount);

        return "result";
    }
}

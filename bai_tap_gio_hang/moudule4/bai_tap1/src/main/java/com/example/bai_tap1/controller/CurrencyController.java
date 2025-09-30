package com.example.bai_tap1.controller;

import com.example.bai_tap1.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/convert")
    public String convert(@RequestParam("usd") String usdAmountStr,
                          @RequestParam("rate") String rateStr,
                          Model model) {
        try {
            // Chuyển đổi và validate input
            double usdAmount = Double.parseDouble(usdAmountStr);
            double exchangeRate = Double.parseDouble(rateStr);

            // Gọi service
            double vndAmount = currencyService.convert(usdAmount, exchangeRate);

            // Gửi kết quả sang JSP
            model.addAttribute("usdAmount", usdAmount);
            model.addAttribute("exchangeRate", exchangeRate);
            model.addAttribute("vndAmount", vndAmount);

            return "result";

        } catch (NumberFormatException e) {
            model.addAttribute("error", "Vui lòng nhập số hợp lệ cho USD và Tỉ giá.");
            return "error";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
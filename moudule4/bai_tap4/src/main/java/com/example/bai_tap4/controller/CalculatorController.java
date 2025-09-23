package com.example.bai_tap4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalculatorController {

    @PostMapping("/calculate")
    public String calculate(@RequestParam double num1,
                            @RequestParam double num2,
                            @RequestParam String operator,
                            Model model) {
        double result = 0;
        String operation = "";

        switch (operator) {
            case "+":
                result = num1 + num2;
                operation = "Addition";
                break;
            case "-":
                result = num1 - num2;
                operation = "Subtraction";
                break;
            case "*":
                result = num1 * num2;
                operation = "Multiplication";
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                    operation = "Division";
                } else {
                    model.addAttribute("error", "Không thể chia cho 0");
                    return "error";
                }
                break;
        }

        model.addAttribute("operation", operation);
        model.addAttribute("result", result);
        return "result";
    }
}
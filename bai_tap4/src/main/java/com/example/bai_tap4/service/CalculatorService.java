package com.example.bai_tap4.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Không thể chia cho 0");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Toán tử không hợp lệ");
        }
    }
}
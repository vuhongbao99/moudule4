package com.example.bai_tap1.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    public double convert(double usd, double rate) {
        if (usd <= 0 || rate <= 0) {
            throw new IllegalArgumentException("Số tiền và tỉ giá phải lớn hơn 0");
        }
        return usd * rate;
    }
}
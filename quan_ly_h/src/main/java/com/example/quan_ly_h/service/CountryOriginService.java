package com.example.quan_ly_h.service;

import com.example.quan_ly_h.entity.CountryOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
import java.util.List;

public class CountryOriginService implements ICountryOriginService{
    @Autowired
    private ICountryOriginService iCountryOriginService;
    @Override
    public List<CountryOrigin> findAll() {
        countryOriginRepository.findAll();
    }
}

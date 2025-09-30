package com.example.bai_tap_gio_hang.service;

import com.example.bai_tap_gio_hang.entity.Candy;

import java.util.Optional;

public interface ICandyService {
    Iterable<Candy> findAll();
    Optional<Candy> findById(Long id);
}

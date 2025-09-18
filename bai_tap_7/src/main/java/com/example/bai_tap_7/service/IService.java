package com.example.bai_tap_7.service;

import com.example.bai_tap_7.entity.Product;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    void save(T t);

    T findById(Integer id);

    void update(Product product);

    void delete(int id);
}

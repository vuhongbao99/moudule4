package com.example.bai_tap_8.service;

import com.example.bai_tap_8.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    List<T> findAll();
    void save(Blog blog);

    Optional<T> findById(Integer id);

    void update(T t);

    void deleteById(Integer id);
}

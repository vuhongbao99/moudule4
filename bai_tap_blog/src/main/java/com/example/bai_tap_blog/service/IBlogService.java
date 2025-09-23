package com.example.bai_tap_blog.service;

import com.example.bai_tap_blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Integer id);
    void add(Blog blog);
    boolean edit(Blog bog);
    boolean delete(Integer id);
    Page<Blog> search(String name, Integer idCategory, Pageable pageable);
}

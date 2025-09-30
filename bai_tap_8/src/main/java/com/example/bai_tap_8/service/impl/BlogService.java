package com.example.bai_tap_8.service.impl;


import com.example.bai_tap_8.entity.Blog;
import com.example.bai_tap_8.service.IBlogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Override
    public List<Blog> findAll() {
        return null;
    }

    @Override
    public void save(Blog blog) {

    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Blog blog) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}

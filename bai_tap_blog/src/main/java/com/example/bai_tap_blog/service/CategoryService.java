package com.example.bai_tap_blog.service;

import com.example.bai_tap_blog.entity.Category;
import com.example.bai_tap_blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findCategory() {
        return categoryRepository.findAll();
    }
}

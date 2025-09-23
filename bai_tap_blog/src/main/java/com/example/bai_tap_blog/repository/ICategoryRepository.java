package com.example.bai_tap_blog.repository;

import com.example.bai_tap_blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}

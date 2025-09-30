package com.example.bai_tap_8.repository;

import com.example.bai_tap_8.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
}

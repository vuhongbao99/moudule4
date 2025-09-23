package com.example.bai_tap_blog.service;

import com.example.bai_tap_blog.entity.Blog;
import com.example.bai_tap_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void add(Blog blog) {
        if (blog.getId() == null || findById(blog.getId()) == null) {
            blogRepository.save(blog);
        }
    }

    @Override
    public boolean edit(Blog bog) {
        if (findById(bog.getId()) != null) {
            bog.setId(bog.getId());
            blogRepository.save(bog);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Blog blog = findById(id);
        if (blog != null) {
            blogRepository.delete(blog);
            return true;
        }
        return false;
    }

    @Override
    public Page<Blog> search(String name, Integer idCategory, Pageable pageable) {
        return blogRepository.search(name,idCategory, pageable);
    }
}

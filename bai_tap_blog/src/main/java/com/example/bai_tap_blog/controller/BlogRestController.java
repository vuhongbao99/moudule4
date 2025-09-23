package com.example.bai_tap_blog.controller;

import com.example.bai_tap_blog.entity.Blog;
import com.example.bai_tap_blog.entity.Category;
import com.example.bai_tap_blog.service.IBlogService;
import com.example.bai_tap_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public Page<Blog> findAll(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "2") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return blogService.findAll(pageable); // trả về Page<BlogDTO>
    }


    @GetMapping("/")
    public ResponseEntity<Page<Blog>> index(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(defaultValue = "title") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "") Integer categoryId) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        int size = 2;
        int searchId;
        if (categoryId == null) {
            searchId = 0;
        } else {
            searchId = categoryId;
        }
        Page<Blog> blogs = blogService.search(keyword, searchId, PageRequest.of(page -1, size, sort));
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping("/{id}/view")
    public ResponseEntity<?> view(@PathVariable Integer id, RedirectAttributes attributes) {
        Blog blog = blogService.findById(id);
        if (blog != null) {

            return new ResponseEntity<>(blog,HttpStatus.OK);
        }

        return new ResponseEntity<>("không tìm thấy blog",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/category")
    public ResponseEntity<?> findCategory() {
        List<Category> categories= categoryService.findCategory();
        return new ResponseEntity<>(categories,HttpStatus.OK);

    }
}

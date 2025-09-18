package com.example.bai_tap_7.service.impl;

import com.example.bai_tap_7.entity.Product;
import com.example.bai_tap_7.repository.ProductRepository;
import com.example.bai_tap_7.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;



@Service
    public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
       return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
          productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
      return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }


    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

}

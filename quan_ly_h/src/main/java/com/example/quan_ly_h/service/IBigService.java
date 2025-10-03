package com.example.quan_ly_h.service;

import com.example.quan_ly_h.entity.Big;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IBigService {
    Page<Big> findAll(Pageable pageable);
    Big  findById(String id);
    Page<Big> search(String keyword,Integer idCountry, Pageable pageable );
    void create(Big big);
    void update(Big big);
    void delete(Big big);

}

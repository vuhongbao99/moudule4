package com.example.bai_tap_muon_sach.service;

import com.example.bai_tap_muon_sach.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(String id);
    void add(Book book);
    void update(Book book);
    String randomBorrowCode();
}

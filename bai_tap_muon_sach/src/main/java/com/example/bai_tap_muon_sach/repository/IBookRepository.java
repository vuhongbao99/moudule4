package com.example.bai_tap_muon_sach.repository;

import com.example.bai_tap_muon_sach.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}

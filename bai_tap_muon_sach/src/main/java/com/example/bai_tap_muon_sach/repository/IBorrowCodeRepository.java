package com.example.bai_tap_muon_sach.repository;

import com.example.bai_tap_muon_sach.entity.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowCodeRepository extends JpaRepository<BorrowCode, Integer> {
}

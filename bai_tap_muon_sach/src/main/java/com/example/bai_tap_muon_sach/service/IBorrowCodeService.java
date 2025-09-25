package com.example.bai_tap_muon_sach.service;

import com.example.bai_tap_muon_sach.entity.BorrowCode;

public interface IBorrowCodeService {
    BorrowCode findByBorrowCode(String id);
    void add(BorrowCode borrowCode);
    void softDelete(BorrowCode borrowCode);
}

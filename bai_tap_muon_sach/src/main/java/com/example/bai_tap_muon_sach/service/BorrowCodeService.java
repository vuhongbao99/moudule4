package com.example.bai_tap_muon_sach.service;

import com.example.bai_tap_muon_sach.entity.BorrowCode;
import com.example.bai_tap_muon_sach.repository.IBorrowCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowCodeService {
    @Autowired
    private IBorrowCodeRepository borrowCodeRepository;

    @Override
    public BorrowCode findByBorrowCode(String id) {
        return (BorrowCode) borrowCodeRepository.findBorrowCodeByBorrowCode(id).orElse(null);
    }

    @Override
    public void add(BorrowCode borrowCode) {
        if (borrowCode.getIdBorrowCode() == null || findByBorrowCode(String.valueOf(borrowCode.getIdBorrowCode())) == null) {
            borrowCodeRepository.save(borrowCode);
        }
    }
    @Override
    public void softDelete(BorrowCode borrowCode) {
        borrowCode.setIsDeleted(true);
        borrowCodeRepository.save(borrowCode);
    }
}

package com.example.bai_tap_gio_hang.service;

import com.example.bai_tap_gio_hang.entity.Candy;
import com.example.bai_tap_gio_hang.repository.ICandyRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandyService implements ICandyService {
    private final ICandyRepo iCandyRepo;

    public CandyService(ICandyRepo iCandyRepo) {
        this.iCandyRepo = iCandyRepo;
    }


    @Override
    public Iterable<Candy> findAll() {
        return iCandyRepo.findAll();
    }

    @Override
    public Optional<Candy> findById(Long id) {
        return iCandyRepo.findById(id);
    }
}

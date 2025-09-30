package com.example.bai_tap_gio_hang.repository;

import com.example.bai_tap_gio_hang.entity.Candy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICandyRepo extends JpaRepository<Candy,Long> {

}

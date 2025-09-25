package com.example.thuc_hanh_validation.repository;

import com.example.thuc_hanh_validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByBirthDay(LocalDate birthday);
}

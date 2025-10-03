package com.example.bao_mat.repository;

import com.example.bao_mat.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String username);
}

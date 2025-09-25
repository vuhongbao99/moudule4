package com.example.thuc_hanh_validation.service;

import com.example.thuc_hanh_validation.entity.User;

public interface IUserService {
    void create(User user);
    User findById(Integer id);
}

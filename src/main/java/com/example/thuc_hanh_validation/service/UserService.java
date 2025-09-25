package com.example.thuc_hanh_validation.service;

import com.example.thuc_hanh_validation.entity.User;
import com.example.thuc_hanh_validation.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;

    @Override
    public void create(User user) {
         if (user.getId() == null || findById(user.getId()) == null){
             userRepository.save(user);
         }
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}

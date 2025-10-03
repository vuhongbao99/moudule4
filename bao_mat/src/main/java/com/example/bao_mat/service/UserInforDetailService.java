package com.example.bao_mat.service;

import com.example.bao_mat.dto.UserInfoUserDetails;
import com.example.bao_mat.entity.AppUser;
import com.example.bao_mat.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInforDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iUserRepository.findByUserName(username);
        if(appUser == null) {
            throw new UsernameNotFoundException("User not found!");
        }
//        Lấy tất cả role của AppUser
        UserInfoUserDetails infoUserDetails = new UserInfoUserDetails(appUser);
        return infoUserDetails;
    }
}

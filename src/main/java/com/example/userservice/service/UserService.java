package com.example.userservice.service;

import com.example.userservice.dto.UserRegisterDto;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.vo.RequestUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserRegisterDto createUser(RequestUser requestUser);

    UserResponse getUserByUserId(String userId);

    List<UserResponse> getUserByAll();

    UserResponse getUserDetailsByEmail(String username);
}

package com.example.userservice.service;

import com.example.userservice.dto.UserRegisterDto;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.vo.RequestUser;

import java.util.List;

public interface UserService {
    UserRegisterDto createUser(RequestUser requestUser);

    UserResponse getUserByUserId(String userId);

    List<UserResponse> getUserByAll();
}

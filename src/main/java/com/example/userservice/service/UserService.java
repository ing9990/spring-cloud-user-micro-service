package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.dto.UserRegisterDto;
import com.example.userservice.vo.RequestUser;

public interface UserService {
    UserRegisterDto createUser(RequestUser requestUser);
}

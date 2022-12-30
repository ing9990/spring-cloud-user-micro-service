package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.dto.UserRegisterDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.vo.RequestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserRegisterDto createUser(RequestUser requestUser) {
        var user =
                UserEntity.makeUser(requestUser.getEmail(), requestUser.getName(),
                        passwordEncoder.encode(requestUser.getPassword()));

        userRepository.save(user);

        return UserRegisterDto.of(user);
    }
}

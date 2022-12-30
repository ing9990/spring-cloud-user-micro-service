package com.example.userservice.service;

import com.example.userservice.dto.UserRegisterDto;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.vo.RequestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public UserResponse getUserByUserId(String userId) {
        var user = userRepository.findUserEntityByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException(userId));

        return UserResponse.of(user);
    }

    @Override
    public List<UserResponse> getUserByAll() {
        return userRepository.findAll()
                .stream().map(UserResponse::of)
                .collect(Collectors.toList());
    }
}


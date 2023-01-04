package com.example.userservice.service;

import com.example.userservice.dto.UserRegisterDto;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.vo.RequestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public UserResponse getUserDetailsByEmail(String email) {
        var user = userRepository.findUserEntityByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email + " 유저를 찾을 수 없습니다."));

        return UserResponse.of(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findUserEntityByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " 유저를 찾을 수 없습니다."));

        return buildUserByEmailPassword(user);
    }

    private User buildUserByEmailPassword(UserEntity user) {
        return new User(user.getEmail(), user.getEncryptedPassword(),
                true, true, true, true,
                new ArrayList<>());
    }
}


package com.example.userservice.controller;

import com.example.userservice.dto.UserRegisterDto;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.RequestUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final Environment env;
    private final UserService userService;

    @GetMapping("/health")
    public String status() {
        return String.format("it's Working in User Service on port %s",
                env.getProperty("local.server.port"));
    }

    @GetMapping("/welcome")
    public String welcome() {
        return env.getProperty("greeting.message");
    }

    @PostMapping("/users")
    public ResponseEntity<UserRegisterDto> createUser(@Valid @RequestBody RequestUser requestUser) {
        var userRegisterDto = userService.createUser(requestUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(userRegisterDto);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        var response = userService.getUserByAll();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUserByUserId(@PathVariable String userId) {
        var repsonse = userService.getUserByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK).body(repsonse);
    }
}
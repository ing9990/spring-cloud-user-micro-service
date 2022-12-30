package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.dto.UserRegisterDto;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.RequestUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final Environment env;
    private final Greeting greeting;
    private final UserService userService;

    @GetMapping("/health")
    public String status() {
        return "it's Working in User Service.";
    }

    @GetMapping("/welcome")
    public String welcome(){
        log.info(greeting.getMessage());

        return env.getProperty("greeting.message");
    }

    @PostMapping("/users")
    public ResponseEntity<UserRegisterDto> createUser(@Valid @RequestBody RequestUser requestUser){
        var userRegisterDto = userService.createUser(requestUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(userRegisterDto);
    }

}

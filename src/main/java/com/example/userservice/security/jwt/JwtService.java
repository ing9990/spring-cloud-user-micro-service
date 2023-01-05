package com.example.userservice.security.jwt;

import com.example.userservice.dto.UserResponse;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public interface JwtService {

    String buildJwtFromUserDetails(String userId, UserResponse userDetails);

}

package com.example.userservice.dto;

import com.example.userservice.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterDto {
    private String email;

    private String name;

    private String userId;

    public static UserRegisterDto of(UserEntity user){
        return new UserRegisterDto(user.getEmail(), user.getName(), user.getUserId());
    }
}

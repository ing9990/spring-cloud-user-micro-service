package com.example.userservice.dto;

import com.example.userservice.entity.UserEntity;
import lombok.Data;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createdAt;
    private String encryptedPwd;

    public static UserDto of(UserEntity user){
        return new UserDto(user.getEmail(), user.getName(), user.getEncryptedPassword()
        ,user.getUserId(), null ,user.getEncryptedPassword());
    }

}

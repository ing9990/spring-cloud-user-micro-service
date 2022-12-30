package com.example.userservice.dto;

import com.example.userservice.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private String email;

    private String name;

    private String userId;

    private List<OrderResponse> orders;

    public static UserResponse of(UserEntity user) {
        return new UserResponse(user.getEmail(), user.getName(), user.getUserId(), new ArrayList<>());
    }
}

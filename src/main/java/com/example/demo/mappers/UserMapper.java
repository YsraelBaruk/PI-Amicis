package com.example.demo.mappers;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;

public class UserMapper {
    public static UserDTO map(User user) {
        return new UserDTO(user.getEmail(), user.getSenha());
    }
}

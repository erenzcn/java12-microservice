package org.example.auth.service;


import org.example.auth.dto.UserDto;
import org.example.auth.dto.UserLoginDto;
import org.example.auth.entity.User;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);


    void login(UserLoginDto userDto);

    UserDto findById(int id);

    String deleteById(int id);
    List<UserDto> findAll();

    User toEntity(UserDto dto);
}

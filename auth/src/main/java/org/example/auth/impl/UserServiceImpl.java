package org.example.auth.impl;


import lombok.RequiredArgsConstructor;
import org.example.auth.dto.UserDto;
import org.example.auth.dto.UserLoginDto;
import org.example.auth.entity.User;
import org.example.auth.exception.AuthException;
import org.example.auth.repository.UserRepository;
import org.example.auth.response.BaseResponse;
import org.example.auth.service.UserCacheService;
import org.example.auth.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserCacheService userCacheService;

    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private int loginAttempts = 0;

    @Override
    public UserDto save(UserDto userDto) {

        UserDto dto = toDto(repository.save(toEntity(userDto)));
        userCacheService.putUser(dto.getId(), dto);
        return userCacheService.getUser(dto.getId());
    }

    @Override
    public void login(UserLoginDto userDto) {
        User user = repository.findByUsername(userDto.getUsername()).orElseThrow(() ->
                new AuthException(new BaseResponse(1001, "User not found")));
        if (user.getStatus()) {
            if (!user.getPassword().equals(userDto.getPassword())) {
                loginAttempts++;
                if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                    user.setStatus(false);
                    repository.save(user);
                    throw new AuthException(new BaseResponse(1003, "Your login attempts have exceeded the limit"));
                } else {
                    throw new AuthException(new BaseResponse(1002, "Password is wrong"));
                }
            }
            loginAttempts = 0;
            throw new AuthException(new BaseResponse(200, "Login successful"));
        } else {
            throw new AuthException(new BaseResponse(1004, "User is blocked, please contact the administrator"));
        }
    }

    @Override
    public UserDto findById(int id) {


        if(userCacheService.getUser(id)!=null){
            return userCacheService.getUser(id);
        }else {
            return toDto(repository.findById(id).orElseThrow(() ->
                    new AuthException(new BaseResponse(1001, "User not found"))));
        }
    }


    @Override
    public String deleteById(int id) {
        User user=repository.findById(id).orElseThrow(() ->
                new AuthException(new BaseResponse(1001, "User not found")));
        repository.deleteById(user.getId());
        return "User named "+user.getName()+ " has been deleted";
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .surname(user.getSurname())
                .status(user.getStatus())
                .username(user.getUsername())
                .build();
    }

    @Override
    public User toEntity(UserDto dto){
        User user=new User();
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setSurname(dto.getSurname());
        user.setStatus(dto.getStatus());
        user.setUsername(dto.getUsername());
        return user;
    }
}

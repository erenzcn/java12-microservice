package org.example.auth.impl;


import lombok.RequiredArgsConstructor;
import org.example.auth.dto.UserDto;
import org.example.auth.entity.User;
import org.example.auth.repository.UserRepository;
import org.example.auth.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public UserDto save(UserDto userDto) {
        return toDto(repository.save(toEntity(userDto)));
    }

    @Override
    public UserDto findById(int id) {
        return toDto(repository.findById(id).orElseThrow(()-> new RuntimeException("User not found")));
    }

    @Override
    public String deleteById(int id) {
        User user=repository.findById(id).orElseThrow(()->
                new RuntimeException("User not found"));
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
                .build();
    }

    @Override
    public User toEntity(UserDto dto){
        User user=new User();
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        return user;
    }
}

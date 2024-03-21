package org.example.auth.controller;

import lombok.RequiredArgsConstructor;
import org.example.auth.dto.UserDto;
import org.example.auth.request.UserRequest;
import org.example.auth.response.UserResponse;
import org.example.auth.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public UserResponse create(@RequestBody UserRequest userRequest){
        return toResponse(service.save(toDto(userRequest)));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return service.deleteById(id);
    }

    @GetMapping("/{id}")
    public UserResponse find(@PathVariable int id){
        return toResponse(service.findById(id));
    }

    @GetMapping("/get-all")
    public List<UserResponse> getAll(){
        return service.findAll().stream().map(this::toResponse).toList();
    }

    public UserResponse toResponse(UserDto dto){
        return UserResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .password(dto.getPassword())
                .build();
    }

    public UserDto toDto(UserRequest userRequest){
        return UserDto.builder()
                .name(userRequest.getName())
                .password(userRequest.getPassword())
                .build();
    }
}

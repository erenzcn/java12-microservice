package org.example.basket.service;

import org.example.basket.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "auth")
public interface AuthFeignCallableApi {

    @GetMapping("/users/{id}")
    UserResponse find(@PathVariable int id);
}

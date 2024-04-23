package org.example.auth.service;

import org.example.auth.dto.UserDto;

public interface UserCacheService {
    UserDto putUser(Integer key, UserDto value);

    UserDto getUser(Integer key);
}

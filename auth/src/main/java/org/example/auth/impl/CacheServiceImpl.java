package org.example.auth.impl;

import com.hazelcast.core.HazelcastInstance;
import org.example.auth.dto.UserDto;
import org.example.auth.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentMap;

@Service
public class CacheServiceImpl implements UserCacheService {


    @Autowired
    @Qualifier(value = "userHazelcast")
    private HazelcastInstance hazelcastInstance;



    private ConcurrentMap<Integer, UserDto> retrieveMap() {
        return hazelcastInstance.getMap("userMap");
    }

    @Override
    public UserDto putUser(Integer key, UserDto value) {
        retrieveMap().put(key, value);
        return getUser(key);
    }

    @Override
    public UserDto getUser(Integer key) {
        return retrieveMap().get(key);
    }

}

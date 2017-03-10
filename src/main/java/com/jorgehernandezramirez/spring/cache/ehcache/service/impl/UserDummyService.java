package com.jorgehernandezramirez.spring.cache.ehcache.service.impl;

import com.jorgehernandezramirez.spring.cache.ehcache.service.api.IUserService;
import com.jorgehernandezramirez.spring.cache.ehcache.service.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDummyService implements IUserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDummyService.class);

    public UserDummyService(){
        //Para Spring
    }

    @Override
    @Cacheable(value = "userCache")
    public List<UserDto> getUsers() {
        LOGGER.info("Obteniendo todos los usuarios del sistema");
        return Arrays.asList(new UserDto("1", "jorge", "hernandez"),
                new UserDto("2", "jose", "hernandez"));
    }
}

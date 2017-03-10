package com.jorgehernandezramirez.spring.cache.ehcache.service.impl;

import com.jorgehernandezramirez.spring.cache.ehcache.service.api.IUserAdminService;
import com.jorgehernandezramirez.spring.cache.ehcache.service.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("userAdminDummyServiceImpl")
public class UserAdminDummyServiceImpl extends UserDummyService implements IUserAdminService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDummyService.class);

    public UserAdminDummyServiceImpl(){
        //For Spring
    }

    @Override
    @Cacheable(value = "userCache")
    public List<UserDto> getAdminUser() {
        LOGGER.info("Obteniendo todos los usuarios administradores del sistema");
        return Arrays.asList(new UserDto("3", "Admin", "Admin"));
    }
}

package com.jorgehernandezramirez.spring.cache.ehcache.controller;

import com.jorgehernandezramirez.spring.cache.ehcache.service.api.IUserService;
import com.jorgehernandezramirez.spring.cache.ehcache.service.dto.UserDto;
import com.jorgehernandezramirez.spring.cache.ehcache.service.impl.UserDummyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    public UserController(){
        //Para Spring
    }

    @RequestMapping
    public List<UserDto> getUsers(){
        LOGGER.info("Llamando al servicio de usuarios para obtener todos los usuarios del sistema.");
        return userService.getUsers();
    }
}

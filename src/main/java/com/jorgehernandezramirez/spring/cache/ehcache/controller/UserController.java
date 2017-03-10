package com.jorgehernandezramirez.spring.cache.ehcache.controller;

import com.jorgehernandezramirez.spring.cache.ehcache.service.api.IUserService;
import com.jorgehernandezramirez.spring.cache.ehcache.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    public UserController(){
        //Para Spring
    }

    @RequestMapping
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }
}

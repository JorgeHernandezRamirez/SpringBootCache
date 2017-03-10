package com.jorgehernandezramirez.spring.cache.ehcache.service.api;

import com.jorgehernandezramirez.spring.cache.ehcache.service.dto.UserDto;

import java.util.List;

/**
 * Api de Usuarios. Se definen los métodos para la gestión de usuarios
 */
public interface IUserService {

    /**
     * Método que devuelve la lista de todos los usuarios del sistema
     * @return
     */
    List<UserDto> getUsers();
}

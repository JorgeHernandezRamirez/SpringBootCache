package com.jorgehernandezramirez.spring.cache.ehcache.service.api;

import com.jorgehernandezramirez.spring.cache.ehcache.service.dto.UserDto;

import java.util.List;

/**
 * Api que debe realizar la gestión de usuarios administrador del sistema
 */
public interface IUserAdminService extends IUserService {

    /**
     * Método que debe devolver la lista de usuarios administradores totales del sistema
     * @return
     */
    List<UserDto> getAdminUser();
}

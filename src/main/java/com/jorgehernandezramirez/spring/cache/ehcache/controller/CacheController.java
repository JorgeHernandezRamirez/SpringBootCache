package com.jorgehernandezramirez.spring.cache.ehcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity clearAllCaches() {
        cacheManager.getCacheNames().forEach(cacheName -> {
            clearCacheFromCacheName(cacheName);
        });
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{cacheName}", method = RequestMethod.DELETE)
    public ResponseEntity clearCache(@PathVariable("cacheName") String cacheName) {
        return clearCacheFromCacheName(cacheName) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    private Boolean clearCacheFromCacheName(final String cacheName) {
        final Cache cache = cacheManager.getCache(cacheName);
        if (cacheExists(cache)) {
            cache.clear();
            return true;
        }
        return false;
    }

    private Boolean cacheExists(final Cache cache) {
        return cache != null;
    }
}

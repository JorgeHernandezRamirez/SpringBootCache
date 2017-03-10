package com.jorgehernandezramirez.spring.cache.ehcache.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = CacheConfigurationTest.class)
@ComponentScan(value = "com.jorgehernandezramirez.spring.cache.ehcache.service")
public class UserConfigurationTest {

}

package com.jorgehernandezramirez.spring.cache.ehcache.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class CacheConfigurationTest {

    private static final String EHCACHE_CONFIGURATION_XML = "ehcache.xml";

    public CacheConfigurationTest() {
        //Para Spring
    }

    @Bean
    public CacheManager ehCacheManager() {
        return new EhCacheCacheManager(this.ehCacheCacheManager().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource(EHCACHE_CONFIGURATION_XML));
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }

    @Bean(name = "keySignatureGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(final Object object, final Method method, final Object... params) {
                final StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(object.getClass().getName());
                stringBuilder.append(method.getName());
                stringBuilder.append(getStringSignatureFromParams(params));
                return stringBuilder.toString();
            }
        };
    }

    private String getStringSignatureFromParams(final Object... params){
        final StringBuilder stringBuilder = new StringBuilder();
        for (final Object param : params) {
            stringBuilder.append(getHashCodeFromObject(param));
        }
        return stringBuilder.toString();
    }

    private Integer getHashCodeFromObject(final Object object){
        if(object == null){
            return 0;
        }
        return object.hashCode();
    }
}

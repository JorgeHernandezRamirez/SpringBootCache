package com.jorgehernandezramirez.spring.cache.ehcache;


import com.jorgehernandezramirez.spring.cache.ehcache.configuration.UserConfigurationTest;
import com.jorgehernandezramirez.spring.cache.ehcache.service.api.IUserAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserConfigurationTest.class,loader=AnnotationConfigContextLoader.class)
public class CacheTest {

    @Autowired
    @Qualifier("userAdminDummyServiceImpl")
    private IUserAdminService userAdminService;

    @Test
    public void shouldBeNotNullImplForIUserAdminService(){
        assertNotNull(userAdminService);
    }

    @Test
    public void shouldGetUsersFromUserAdminService(){
        assertEquals(2, userAdminService.getUsers().size());
        assertEquals(1, userAdminService.getAdminUser().size());
        assertEquals(2, userAdminService.getUsers().size());
        assertEquals(1, userAdminService.getAdminUser().size());
    }
}

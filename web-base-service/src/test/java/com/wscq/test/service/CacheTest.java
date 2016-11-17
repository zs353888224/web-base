package com.wscq.test.service;

import com.wscq.initdb.mybatis.model.TUser;
import com.wscq.service.model.UserDto;
import com.wscq.service.service.cache.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by monst on 2016/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class CacheTest {

    @Inject
    CacheService cacheService;

    @Test
    public void testJNJ(){
        cacheService.save("usertest", new UserDto());
        System.out.println("data is save");
        UserDto userDto = (UserDto) cacheService.get("usertest");
        System.out.println("the data is" + userDto.toString());
        cacheService.delete("usertest");
        userDto = (UserDto) cacheService.get("usertest");
        System.out.println("the data is:" + userDto);

    }
}

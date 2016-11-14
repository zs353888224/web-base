package com.wscq.test.mybatis;

import com.wscq.service.service.TestService;
import com.wscq.service.service.UserService.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by monst on 2016/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class MybatisTest {

    @Inject
    TestService testService;

    @Test
    public void testFSFSA() {
        System.out.println("hello world!");
    }

    @Test
    public void testHBJB() {
        System.out.println(testService.toString());
        testService.selectAll();
    }

    @Test
    public void testJHJK(){
        testService.selectALL2();
    }
}

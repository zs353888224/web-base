package com.wscq.service.service;

import com.wscq.initdb.mybatis.model.TUser;
import com.wscq.initdb.mybatis.repository.mybatis.TUserMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by monst on 2016/11/14.
 */
@Service
public class TestService {
    @Inject
    TUserMapper userMapper;

    public void selectAll(){
        List<TUser> list = userMapper.getAll();
        System.out.println(list.isEmpty() ? "wo ca ne!" : list.get(0).toString());
    }

    public void selectALL2(){
        List<TUser> list = userMapper.getAll2();
        System.out.println(list.isEmpty() ? "wo ca ne!" : list.get(0).toString());
    }
}

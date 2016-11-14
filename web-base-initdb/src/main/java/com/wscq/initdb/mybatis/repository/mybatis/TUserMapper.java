package com.wscq.initdb.mybatis.repository.mybatis;

import com.wscq.initdb.mybatis.model.TUser;
import com.wscq.initdb.mybatis.repository.CrudMapper;
import com.wscq.initdb.mybatis.repository.MybatisMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by monst on 2016/11/14.
 */
@MybatisMapper
public interface TUserMapper extends CrudMapper<TUser, Integer> {

    @Select("select * from t_user")
    List<TUser> getAll();

    List<TUser> getAll2();
}

package com.wscq.initdb.elastsearch.repository.elastsearch;

import com.wscq.initdb.mybatis.model.TUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Created by monst on 2016/11/15.
 */
@NoRepositoryBean
public interface UserRepository extends CrudRepository<TUser, Long> {

    Long deleteByLastname(String lastname);

    List<TUser> removeByLastname(String lastname);


}

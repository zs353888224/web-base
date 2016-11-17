package com.wscq.initdb.elastsearch.repository;

import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * 提供自己的接口类
 *
 * Created by monst on 2016/11/15.
 */
public interface CrudRepository <T, ID extends Serializable> extends Repository<T, ID> {
    <S extends T> S save(S entity);
    // TODO 后续再编写增加
}

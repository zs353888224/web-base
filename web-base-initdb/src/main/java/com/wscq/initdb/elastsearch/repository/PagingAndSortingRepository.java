package com.wscq.initdb.elastsearch.repository;

import org.springframework.data.domain.*;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * 分页查询
 *
 * Created by monst on 2016/11/15.
 */
public interface PagingAndSortingRepository<T, ID extends Serializable>
        extends CrudRepository<T, ID> {

    Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);
}

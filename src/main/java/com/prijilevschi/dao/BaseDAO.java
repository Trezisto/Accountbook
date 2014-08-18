package com.prijilevschi.dao;

import java.util.List;

import com.prijilevschi.model.AbstractEntity;


/**
 * Abstract DAO layer, common for all models
 *
 */
public interface BaseDAO<T extends AbstractEntity> {
    Long persist(T entity);
    T merge(T entity);
    T findById(Long id);
    List<T> findAll();
    void remove(T entity);
    void removeById(Long id);
}

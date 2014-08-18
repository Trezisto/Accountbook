package com.prijilevschi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.prijilevschi.dao.BaseDAO;
import com.prijilevschi.model.AbstractEntity;

public class AbstractBaseDAO<T extends AbstractEntity> implements BaseDAO<T>{

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityType;

    AbstractBaseDAO(Class<T> classType){
        entityType = classType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long persist(T entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T merge(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
        return findById(entity.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T findById(Long id) {
        return entityManager.find(entityType, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from " + entityType.getName(), entityType).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeById(Long id) {
        entityManager.remove(findById(id));
    }

    /**
     * Getter for entityType.
     * @return the entityType
     */
    public Class<T> getEntityType() {
        return entityType;
    }

}

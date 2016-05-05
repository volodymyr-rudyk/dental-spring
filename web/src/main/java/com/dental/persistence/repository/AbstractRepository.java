package com.dental.persistence.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by light on 4/5/2015.
 */
@Repository
public abstract class AbstractRepository<T> implements GenericRepository<T> {

  @PersistenceContext
  protected EntityManager entityManager;

  private Class<T> clazz;

  public AbstractRepository(Class<T> clazz) {
    this.clazz = clazz;
  }

  @Override
  public T get(Long id) {
    return entityManager.find(clazz, id);
  }

  @Override
  public T save(T entity) {
    entityManager.persist(entity);
    return entity;
  }

  @Override
  public List<T> getList() {
    String all = "SELECT * FROM " + clazz.getSimpleName();
    Query nativeQuery = entityManager.createNativeQuery(all, clazz);
    return nativeQuery.getResultList();
  }

  @Override
  public void remove(Long id) {
    T entity = this.get(id);
    entityManager.remove(entity);
  }

  @Override
  public T update(T entity) {
    entityManager.persist(entity);
    return entity;
  }
}

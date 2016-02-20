package com.dental.persistence.component;

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
@Transactional
public abstract class AbstractDao<T> implements GenericCrud<T> {

  @PersistenceContext
  protected EntityManager entityManager;

  private Class<T> clazz;

  public AbstractDao(Class<T> clazz) {
    this.clazz = clazz;
  }

  @Override
  public T get(int id) {
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
  public void remove(int id) {
    T entity = this.get(id);
    entityManager.remove(entity);
  }

  @Override
  public T update(T entity) {
    entityManager.persist(entity);
    return entity;
  }
}

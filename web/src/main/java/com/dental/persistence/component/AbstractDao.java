package com.dental.persistence.component;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
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

  public T get(Serializable id) {
    return entityManager.find(clazz, id);
  }

  public T save(T entity) {
    entityManager.persist(entity);
    return entity;
  }

  public List<T> getList() {
    String all = "SELECT * FROM " + clazz.getSimpleName();
    Query nativeQuery = entityManager.createNativeQuery(all, clazz);
    return nativeQuery.getResultList();
  }

  public void remove(int id) {
    T entity = this.get(id);
    entityManager.remove(entity);
  }

  public T update(T entity) {
    entityManager.persist(entity);
    return entity;
  }
}

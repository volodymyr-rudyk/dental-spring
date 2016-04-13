package com.dental.persistence.repository;

import java.util.List;

/**
 * Created by light on 4/5/2015.
 */
public interface GenericRepository<T> {
  T get(Long id);

  T save(T entity);

  List<T> getList();

  void remove(Long id);

  T update(T entity);
}

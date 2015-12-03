package com.dental.persistence.component;

import java.util.List;

/**
 * Created by light on 4/5/2015.
 */
public interface GenericCrud<T> {
  T get(int id);

  T save(T entity);

  List<T> getList();

  void remove(int id);

  T update(T entity);
}

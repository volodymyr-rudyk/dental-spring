package com.dental.dao.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by light on 4/5/2015.
 */
public interface GenericCrud<T> {
    T get(int id);
    void save(T entity);
    List<T> getList();
    void remove(int id);
    void update(T entity);
}

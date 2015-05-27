package com.dental.dao.impl;

import com.dental.dao.component.AbstractDao;
import com.dental.dao.component.ProfileDao;
import com.dental.dao.entity.Profile;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 27.05.2015.
 */
@Repository
public class ProfileDaoImpl extends AbstractDao implements ProfileDao {

  @Override
  public Profile get(Serializable id) {
    return (Profile) sessionFactory.openSession().get(Profile.class, id);
  }

  @Override
  public Profile save(Profile entity) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(entity);

    return entity;
  }

  @Override
  public List<Profile> getList() {
    Criteria criteria = sessionFactory.openSession().createCriteria(Profile.class);
    return (List<Profile>) criteria.list();
  }

  @Override
  public void remove(int id) {
    Object o = sessionFactory.getCurrentSession().get(Profile.class, id);
    sessionFactory.getCurrentSession().delete(o);
  }

  @Override
  public Profile update(Profile entity) {
    sessionFactory.getCurrentSession().update(entity);
    return entity;
  }

}

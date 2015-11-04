package com.dental.persistence.impl;

import com.dental.persistence.component.AbstractDao;
import com.dental.persistence.component.UserDao;
import com.dental.persistence.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by light on 4/5/2015.
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

  public UserDaoImpl() {
    super(User.class);
  }

  @Override
  public User loadUserByUserNameAndPassword(String login, String password) {
    String q = "select u from User u where u.login = :login and u.password = :password";
    Query namedQuery = entityManager.createQuery(q);
    namedQuery.setParameter("login", login);
    namedQuery.setParameter("password", password);
    namedQuery.setMaxResults(1);
    List resultList = namedQuery.getResultList();
    return resultList.size() > 0 ? (User) resultList.get(0) : null;
  }

  @Override
  public User loadUserByLogin(String login) {
    String q = "select u from User u where u.login = :login";
    Query namedQuery = entityManager.createQuery(q);
    namedQuery.setParameter("login", login);
    namedQuery.setMaxResults(1);
    List resultList = namedQuery.getResultList();
    return resultList.size() > 0 ? (User) resultList.get(0) : null;
  }

  //
//    public void deleteEmployeeBySsn(String ssn) {
//        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
//        query.setString("ssn", ssn);
//        query.executeUpdate();
//    }
//
//
//    public Employee findBySsn(String ssn){
//        Criteria criteria = getSession().createCriteria(Employee.class);
//        criteria.add(Restrictions.eq("ssn",ssn));
//        return (Employee) criteria.uniqueResult();
//    }
//
//    public void updateEmployee(Employee employee){
//        getSession().update(employee);
//    }
}

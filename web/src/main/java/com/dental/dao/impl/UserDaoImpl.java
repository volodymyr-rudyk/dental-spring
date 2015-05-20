package com.dental.dao.impl;

import com.dental.dao.entity.User;
import com.dental.dao.component.AbstractDao;
import com.dental.dao.component.UserDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import javax.security.auth.login.CredentialException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by light on 4/5/2015.
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao<User> {

    @Override
    public User get(Serializable id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User save(User entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);

        return entity;
    }

    @Override
    public List<User> getList() {
        Criteria criteria = sessionFactory.openSession().createCriteria(User.class);
        return criteria.list();
    }

    @Override
    public void remove(int id) {
        Object o = sessionFactory.getCurrentSession().get(User.class, id);
        sessionFactory.getCurrentSession().delete(o);
    }

    @Override
    public User update(User entity) {
        sessionFactory.getCurrentSession().update(entity);
        return entity;
    }

    @Override public User loadUserByUserNameAndPassword(String userName, String password) {
        String q = "select u from User u where u.login = :login";
        Query query = sessionFactory.getCurrentSession().createQuery(q);
        query.setString("login", userName);
        Object result = query.uniqueResult();
        return result != null ? (User) result : null;
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

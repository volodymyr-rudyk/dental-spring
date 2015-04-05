package com.dental.dao.impl;

import com.dental.dao.entity.User;
import com.dental.dao.service.GenericDao;
import com.dental.dao.service.UserDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by light on 4/5/2015.
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl extends GenericDao implements UserDao {

    @Override
    public User get(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void save(User entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public List<User> getList() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }

    @Override
    public void remove(int id) {
        Object o = sessionFactory.getCurrentSession().get(User.class, id);
        sessionFactory.getCurrentSession().delete(o);
    }

    @Override
    public void update(User entity) {
        sessionFactory.getCurrentSession().update(entity);
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

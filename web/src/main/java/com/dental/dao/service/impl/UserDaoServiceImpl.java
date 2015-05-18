package com.dental.dao.service.impl;

import com.dental.dao.entity.User;
import com.dental.dao.service.UserDao;
import com.dental.dao.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by light on 3/28/2015.
 */
@Service
public class UserDaoServiceImpl implements UserDaoService<User> {

    @Autowired
    private UserDao userDao;

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public void save(User entity) {
        userDao.save(entity);
    }

    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    public void remove(int id) {
        userDao.remove(id);
    }

    @Override
    public void update(User entity) {
        userDao.update(entity);
    }
}

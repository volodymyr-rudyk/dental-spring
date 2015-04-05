
package com.dental.dao.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by light on 4/5/2015.
 */
public abstract class GenericDao {

    @Autowired
    protected SessionFactory sessionFactory;
}

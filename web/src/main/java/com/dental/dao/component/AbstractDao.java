
package com.dental.dao.component;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by light on 4/5/2015.
 */
public abstract class AbstractDao {

    @Autowired
    protected SessionFactory sessionFactory;
}

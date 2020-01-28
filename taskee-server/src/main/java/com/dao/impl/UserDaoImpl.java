package com.dao.impl;

import com.dao.UserDao;
import com.dao.model.UserModel;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    EntityManager entityManager;

    @Override
    public UserModel findUserByUserName(String userName) {
        return (UserModel) entityManager.unwrap(Session.class).createCriteria(UserModel.class).add(Restrictions.eq("userName", userName)).uniqueResult();
    }

    @Override
    public void saveUser(UserModel userModel) {
        entityManager.unwrap(Session.class).saveOrUpdate(userModel);
    }
}

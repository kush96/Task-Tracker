//package com.dao.impl;
//
//import com.dao.ProjectDao;
//import com.dao.model.BookingModel;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import javax.persistence.EntityManager;
//
//@Repository
//public class ProjectDaoImpl implements ProjectDao {
//
//    @Autowired
//    private EntityManager entityManager;
//
//    @Override
//    public String getHostName(String name) {
//        BookingModel bookingModel = entityManager.unwrap(Session.class).load(BookingModel.class,name);
//        return bookingModel.getHostName();
//    }
//}

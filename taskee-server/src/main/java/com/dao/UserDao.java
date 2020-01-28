package com.dao;

import com.dao.model.UserModel;

public interface UserDao {
    UserModel findUserByUserName(String userName);
    void saveUser(UserModel userModel);
}

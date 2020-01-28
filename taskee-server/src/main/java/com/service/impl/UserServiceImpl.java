package com.service.impl;

import com.dao.UserDao;
import com.dao.model.UserDetailImpl;
import com.dao.model.UserModel;
import com.dto.request.UserRequestDto;
import com.dto.response.ResponseMessage;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel user = userDao.findUserByUserName(s);
        if(user==null)
            throw new UsernameNotFoundException(s);
        return new UserDetailImpl(user);
    }

    @Override
    public ResponseMessage addUser(UserRequestDto requestDto) {
        try {
            UserModel userModel = new UserModel();
            userModel.setEnterpriseId(requestDto.getEnterpriseId());
            userModel.setUserName(requestDto.getUserName());
            userModel.setPassword(requestDto.getPassword());
            userDao.saveUser(userModel);
        }
        catch(Exception e){
            return new ResponseMessage("Error creating new user");
        }
        return new ResponseMessage("User created successfully");
    }
}

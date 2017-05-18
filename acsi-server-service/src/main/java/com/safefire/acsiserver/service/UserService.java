package com.safefire.acsiserver.service;

import com.safefire.acsiserver.entity.UserEntity;
import com.safefire.acsiserver.dao.mapinterface.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Leo on 2017/5/16.
 */
@Service
public class UserService {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    public Integer getCount(){
        return userMapper.getCount();
    }

    public UserEntity findUserById(Integer id){
        return userMapper.findUserById(id);
    }

    public UserEntity findUserByUserName(String userName){
        return userMapper.findUserByUserName(userName);
    }
}

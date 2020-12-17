package com.mycode.javalearn.service;

import com.mycode.javalearn.dao.UserDao;
import com.mycode.javalearn.model.DO.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author toolman
 * @Date 2020/12/15 21:59
 **/
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public User getById(String id) {
        return userDao.selectById(id);
    }
}

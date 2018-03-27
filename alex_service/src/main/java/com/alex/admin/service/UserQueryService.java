package com.alex.admin.service;

import com.alex.admin.dao.UserDao;
import com.alex.admin.entity.UUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryService
{
    @Autowired
    private UserDao userDao;

    @Cacheable(value = "userList")
    public List<UUser> getUserList()
    {
        return userDao.getUserList();
    }
}

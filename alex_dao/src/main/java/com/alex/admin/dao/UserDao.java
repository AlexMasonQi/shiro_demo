package com.alex.admin.dao;

import com.alex.admin.entity.UUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao
{
    public List<UUser> getUserList();
}

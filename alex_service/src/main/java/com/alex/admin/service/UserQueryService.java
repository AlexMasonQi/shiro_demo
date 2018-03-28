package com.alex.admin.service;

import com.alex.admin.dao.UserDao;
import com.alex.admin.entity.UPermission;
import com.alex.admin.entity.URole;
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

    /**
      * @description 获取所有用户信息
      * @author Alex
      * @date 2018.03.28 10:56
      * @param
      * @return List<UUser>集合
      */
    @Cacheable(value = "userList")
    public List<UUser> getUserList()
    {
        return userDao.getUserList();
    }

    /**
      * @description  根据用户名查找对应用户信息
      * @author Alex
      * @date 2018.03.28 10:57
      * @param userName 登录的用户名
      * @return UUser对象
      */
    @Cacheable(value="userInfo")
    public UUser getUserByName(String userName)
    {
        return userDao.getUserByUserName(userName);
    }

    /**
      * @description  根据用户ID查找对应角色信息
      * @author Alex
      * @date 2018.03.28 10:58
      * @param userId 用户ID
      * @return URole对象
      */
    @Cacheable(value="role")
    public URole getRoleByUserId(Integer userId)
    {
        return userDao.getRoleById(userId);
    }

    /**
      * @description 根据角色ID查找对应的权限
      * @author Alex
      * @date 2018.03.28 14:00
      * @param roleId 角色ID
      * @return List<UPermission>集合
      */
    @Cacheable(value="userPermissions")
    public List<UPermission> getPermissionsById(Integer roleId)
    {
        return userDao.getPermissionsByRoleId(roleId);
    }
}

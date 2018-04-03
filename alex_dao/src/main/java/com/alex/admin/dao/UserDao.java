package com.alex.admin.dao;

import com.alex.admin.entity.Permission;
import com.alex.admin.entity.Role;
import com.alex.admin.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao
{
    public List<User> getUserList();

    public User getUserByUserName(@Param("userName") String userName);

    public Role getRoleById(Integer id);

    public List<Permission> getPermissionsByRoleId(Integer roleId);
}

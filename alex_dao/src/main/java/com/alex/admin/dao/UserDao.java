package com.alex.admin.dao;

import com.alex.admin.entity.UPermission;
import com.alex.admin.entity.URole;
import com.alex.admin.entity.UUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao
{
    public List<UUser> getUserList();

    public UUser getUserByUserName(String userName);

    public URole getRoleById(Integer id);

    public List<UPermission> getPermissionsByRoleId(Integer roleId);
}

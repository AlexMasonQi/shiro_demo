package com.alex.admin.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UUser implements Serializable
{
    private Long id;
    private String nickName;
    private String email;
    private String pswd;
    private Integer role;
    private LocalDateTime createTime;
    private LocalDateTime lastLoginTime;
    private Long status;

    public UUser()
    {
    }

    public UUser(Long id, String nickName, String email, String pswd, Integer role, LocalDateTime createTime, LocalDateTime lastLoginTime, Long status)
    {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.pswd = pswd;
        this.role=role;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.status = status;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPswd()
    {
        return pswd;
    }

    public void setPswd(String pswd)
    {
        this.pswd = pswd;
    }

    public Integer getRole()
    {
        return role;
    }

    public void setRole(Integer role)
    {
        this.role = role;
    }

    public LocalDateTime getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime)
    {
        this.createTime = createTime;
    }

    public LocalDateTime getLastLoginTime()
    {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getStatus()
    {
        return status;
    }

    public void setStatus(Long status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "UUser{" + "id=" + id + ", nickName='" + nickName + '\'' + ", email='" + email + '\'' + ", pswd='" + pswd + '\'' + ", role=" + role + ", createTime=" + createTime + ", lastLoginTime=" + lastLoginTime + ", status=" + status + '}';
    }
}

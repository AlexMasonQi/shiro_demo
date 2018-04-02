package com.alex.admin.entity;

import java.io.Serializable;

public class UUserRole implements Serializable
{
    private Integer uId;
    private Integer rId;

    public UUserRole()
    {
    }

    public UUserRole(Integer uId, Integer rId)
    {
        this.uId = uId;
        this.rId = rId;
    }

    public Integer getuId()
    {
        return uId;
    }

    public void setuId(Integer uId)
    {
        this.uId = uId;
    }

    public Integer getrId()
    {
        return rId;
    }

    public void setrId(Integer rId)
    {
        this.rId = rId;
    }

    @Override
    public String toString()
    {
        return "UUserRole{" + "uId=" + uId + ", rId=" + rId + '}';
    }
}



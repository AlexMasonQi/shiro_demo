package com.alex.admin.entity;

import java.io.Serializable;

public class URolePermission implements Serializable
{
    private Integer rId;
    private Integer pId;

    public URolePermission()
    {
    }

    public URolePermission(Integer rId, Integer pId)
    {
        this.rId = rId;
        this.pId = pId;
    }

    public Integer getrId()
    {
        return rId;
    }

    public void setrId(Integer rId)
    {
        this.rId = rId;
    }

    public Integer getpId()
    {
        return pId;
    }

    public void setpId(Integer pId)
    {
        this.pId = pId;
    }

    @Override
    public String toString()
    {
        return "URolePermission{" + "rId=" + rId + ", pId=" + pId + '}';
    }
}

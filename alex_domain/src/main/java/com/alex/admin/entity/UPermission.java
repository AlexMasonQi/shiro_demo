package com.alex.admin.entity;

import java.io.Serializable;

public class UPermission implements Serializable
{
    private Integer id;
    private String url;
    private String name;

    public UPermission()
    {
    }

    public UPermission(Integer id, String url, String name)
    {
        this.id = id;
        this.url = url;
        this.name = name;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "UPermission{" + "id=" + id + ", url='" + url + '\'' + ", name='" + name + '\'' + '}';
    }
}

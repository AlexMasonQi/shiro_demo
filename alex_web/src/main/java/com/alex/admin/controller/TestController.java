package com.alex.admin.controller;

import com.alex.admin.entity.UUser;
import com.alex.admin.service.UserQueryService;
import com.alex.admin.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController
{
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserQueryService userQueryService;

    @RequestMapping("/index")
    public String showIndex()
    {
        return "index";
    }
}

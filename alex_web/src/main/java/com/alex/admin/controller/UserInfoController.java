package com.alex.admin.controller;

import com.alex.admin.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/info")
public class UserInfoController extends BaseController
{
    @Autowired
    private UserQueryService userQueryService;

    @RequestMapping("/userPermission")
    public String showUserPermissions(Map model)
    {
        return "information";
    }
}

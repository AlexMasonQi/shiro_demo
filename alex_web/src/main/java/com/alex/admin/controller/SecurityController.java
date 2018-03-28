package com.alex.admin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class SecurityController
{
    private static final Logger logger= LoggerFactory.getLogger(SecurityController.class);

    @RequiresRoles("ADMIN")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model)
    {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("username", userName);
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String defaultIndex(Model model)
    {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("username", userName);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm()
    {
        return "login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole()
    {
        logger.info("------没有权限-------");
        return "403";
    }

    @RequestMapping("/login")
    public String userLogin(HttpServletRequest request,Map model)
    {
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String shiroException= (String) request.getAttribute("shiroLoginFailure");
        String msg="OK";

        if(shiroException!=null)
        {
            if (UnknownAccountException.class.getName().equals(shiroException))
            {
                msg = "UnknownAccountException -- > 账号不存在：";
                logger.error(msg);
            }
            else if (IncorrectCredentialsException.class.getName().equals(shiroException))
            {
                msg = "IncorrectCredentialsException -- > 密码不正确：";
                logger.error(msg);
            }
            else
            {
                msg = "else -- >"+shiroException;
                logger.error(msg);
            }
        }
        model.put("msg",msg);
        logger.info("登录成功");

        return "login";
    }
}

package com.cys.crowdfunding.controller;

import com.cys.crowdfunding.bean.User;
import com.cys.crowdfunding.manager.dao.UserMapper;
import com.cys.crowdfunding.manager.service.UserService;
import com.cys.crowdfunding.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sam
 * @apiNote 分发请求
 * @since 2019-09-02-8:00
 **/
@Controller
public class DispatchController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/doLogin")
    public String doLogin(String loginact, String userpswd, String type, HttpSession session) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("loginacct", loginact);
        paramMap.put("userpswd", userpswd);
        paramMap.put("type", type);
        //因为配置了事务，需要以query开头

        User user = userService.queryUserlogin(paramMap);
        session.setAttribute(Const.LOGIN_USER, user);

        return "redirect:/main.htm"; //直接写是转发，防止重复提交表单
    }
}

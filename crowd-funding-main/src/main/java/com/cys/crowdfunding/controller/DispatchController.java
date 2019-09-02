package com.cys.crowdfunding.controller;

import com.cys.crowdfunding.bean.User;
import com.cys.crowdfunding.manager.service.UserService;
import com.cys.crowdfunding.utils.AjaxResult;
import com.cys.crowdfunding.utils.Const;
import com.cys.crowdfunding.utils.MD5Util;
import org.apache.log4j.helpers.ThreadLocalMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sam
 * @version 1.0
 * 用于分发请求的Controller
 * @since 2019-09-02-8:00
 **/
@Controller
public class DispatchController {

    @Autowired
    private UserService userService;

    /**
     * @return 请求首页
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * @return 请求登陆页
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * @return 登陆成功后重定向到后台管理页面
     */
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    /**
     * 异步实现登陆功能
     *
     * @param loginacct 用户名
     * @param userpswd  密码
     * @param type      用户类型
     * @param session   将查询出的用户名存到session域中
     * @return 登陆成功后重定向到后台管理页面，失败抛出异常由SimpleMappingExceptionResolver管理
     * @ResponseBody 结合Jackson组件，将返回结果转换为字符串，将json串以流的形式返回给客户端
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public Object doSynLogin(String loginacct, String userpswd, String type, HttpSession session) {
        AjaxResult result = new AjaxResult();
        try {
            QueryUser(loginacct, userpswd, type, session);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMessage("登陆失败");
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 实现登陆功能
     *
     * @param loginacct 用户名
     * @param userpswd  密码
     * @param type      用户类型
     * @param session   将查询出的用户名存到session域中
     * @return 登陆成功后重定向到后台管理页面，失败抛出异常由SimpleMappingExceptionResolver管理
     * @deprecated 同步请求，废弃！
     */
    //@RequestMapping("/doLogin")
    public String doLogin(String loginacct, String userpswd, String type, HttpSession session) {
        QueryUser(loginacct, userpswd, type, session);
        //重定向，防止重复提交表单
        return "redirect:/main.htm";
    }

    private void QueryUser(String loginacct, String userpswd, String type, HttpSession session) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("loginacct", loginacct);
        paramMap.put("userpswd", MD5Util.digest(userpswd));
        paramMap.put("type", type);
        System.out.println(paramMap);
        //因为配置了事务，需要以query开头
        User user = userService.queryUserlogin(paramMap);
        session.setAttribute(Const.LOGIN_USER, user);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //销毁session对象，或清理session域名
        session.invalidate();
        return "redirect:/index.htm";
    }
}

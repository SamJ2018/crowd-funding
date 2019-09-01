package com.cys.crowdfunding.manager.controller;

import com.cys.crowdfunding.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-01-3:52 PM
 **/
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * @Autowired 首先byType进行类型查找，找到一个直接注入
     * 如果找到多个，再根据名字查找，将多个对象其中名称与变量名称一致的那个bean注入进来
     * 如果多个对象没有名称是与变量名称一致的，可以使用@Qualified()将其中的一个注入进来
     * 如果@Qualified没有与任何一个bean的名称一致，就会报错。
     * 如果不希望报错，可以使用@Autowire(require=false)但是开发中不建议这样做，因为controller一定要调用service层
     * 或者使用@primary()
     *
     * Aop原理：动态代理
     *  如果目标对象有接口，默认采用jdk动态代理（代理类和目标类实现共同的接口）
     *  没有接口使用Cglib动态代理（基于继承（代理类是目标类的子类））
     *  推荐使用JDK动态代理，面向接口编程，面向抽象编程
     * @return
     */
    @RequestMapping("/test")
    public String test(){
        System.out.println("testController");
        testService.insert();
        return "success";
    }
}

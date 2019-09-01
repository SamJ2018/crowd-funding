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

    @RequestMapping("/test")
    public String test(){
        System.out.println("testController");
        testService.insert();
        return "success";
    }
}

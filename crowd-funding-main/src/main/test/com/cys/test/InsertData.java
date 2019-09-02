package com.cys.test;

import com.cys.crowdfunding.bean.User;
import com.cys.crowdfunding.manager.service.UserService;
import com.cys.crowdfunding.utils.MD5Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-02-22:31
 **/
@ContextConfiguration(locations = "classpath:/spring/spring-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class InsertData {

    @Autowired
    UserService userService;

    @Test
    public void test01() {
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setLoginacct("test" + i);
            user.setUserpswd(MD5Util.digest("123"));
            user.setUsername("test" + i);
            user.setEmail("test@cys.com");
            user.setCreatetime("2019-09-23 13:17:00");
            userService.saveUser(user);
        }
    }
}

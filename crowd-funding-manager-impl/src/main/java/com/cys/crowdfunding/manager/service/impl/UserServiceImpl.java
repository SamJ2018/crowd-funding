package com.cys.crowdfunding.manager.service.impl;

import com.cys.crowdfunding.bean.User;
import com.cys.crowdfunding.exception.LoginFailException;
import com.cys.crowdfunding.manager.dao.UserMapper;
import com.cys.crowdfunding.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-02-8:49
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserlogin(Map<String, Object> paramMap) {
        User user = userMapper.queryUserlogin(paramMap);
        if (user == null) {
            throw new LoginFailException("用户帐号或密码不正确!");
        }
        return user;
    }
}

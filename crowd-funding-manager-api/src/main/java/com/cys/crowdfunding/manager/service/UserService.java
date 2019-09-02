package com.cys.crowdfunding.manager.service;

import com.cys.crowdfunding.bean.User;

import java.util.Map;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-02-8:48
 **/

public interface UserService {
    User queryUserlogin(Map<String, Object> paramMap);
}

package com.cys.crowdfunding.manager.service;

import com.cys.crowdfunding.bean.User;
import com.cys.crowdfunding.utils.Page;

import java.util.Map;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-02-8:48
 **/

public interface UserService {
    User queryUserlogin(Map<String, Object> paramMap);

    Page queryPage(Integer pageno, Integer pagesize);

    int saveUser(User user);
}

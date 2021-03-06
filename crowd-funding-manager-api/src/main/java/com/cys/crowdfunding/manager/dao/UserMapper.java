package com.cys.crowdfunding.manager.dao;

import com.cys.crowdfunding.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

	User queryUserlogin(Map<String, Object> paramMap);

    List<User> queryList(@Param("startIndex") Integer startIndex, @Param("pagesize") Integer pagesize);

    Integer queryCount();
}
package com.cys.crowdfunding.manager.dao;

import com.cys.crowdfunding.bean.Return;

import java.util.List;

public interface ReturnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Return record);

    Return selectByPrimaryKey(Integer id);

    List<Return> selectAll();

    int updateByPrimaryKey(Return record);
}
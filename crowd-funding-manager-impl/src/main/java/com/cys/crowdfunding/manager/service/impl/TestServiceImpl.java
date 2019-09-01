package com.cys.crowdfunding.manager.service.impl;

import com.cys.crowdfunding.manager.dao.TestDao;
import com.cys.crowdfunding.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-01-3:55 PM
 **/
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    public void insert() {
        Map map = new HashMap();
        map.put("name", "张三");
        try {
            testDao.insert(map);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}

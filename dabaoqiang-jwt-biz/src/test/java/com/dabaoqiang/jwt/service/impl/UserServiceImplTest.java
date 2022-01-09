package com.dabaoqiang.jwt.service.impl;

import com.alibaba.fastjson.JSON;
import com.dabaoqiang.jwt.BaseTest;
import com.dabaoqiang.jwt.mybatis.domain.User;
import com.dabaoqiang.jwt.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xq
 */
class UserServiceImplTest extends BaseTest {

    @Resource
    private IUserService iUserService;

    @Test
    void selectUser() {
        User user = iUserService.selectUser(1L);
        System.out.println(JSON.toJSONString(user));

    }
}
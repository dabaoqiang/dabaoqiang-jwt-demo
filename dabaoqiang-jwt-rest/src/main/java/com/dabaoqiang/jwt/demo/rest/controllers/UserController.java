package com.dabaoqiang.jwt.demo.rest.controllers;


import com.alibaba.fastjson.JSON;
import com.dabaoqiang.jwt.common.result.Result;
import com.dabaoqiang.jwt.common.util.JwtTokenUtil;
import com.dabaoqiang.jwt.demo.rest.BaseController;
import com.dabaoqiang.jwt.model.request.LoginModelReq;
import com.dabaoqiang.jwt.mybatis.domain.User;
import com.dabaoqiang.jwt.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xq
 * @since 2022-01-08
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private IUserService iUserService;

    @GetMapping(value = "/info")
    public Result info() {
        User user = iUserService.selectUser(getUserId());
        return Result.ok(user);
    }

    @PostMapping(value = "/login")
    public Result login(@RequestBody LoginModelReq loginModelReq) throws IOException {
        User user = iUserService.selectUser(loginModelReq.getId());
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        String jwt = JwtTokenUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(user), JwtTokenUtil.ttlMillis);
        return Result.ok(jwt);
    }

}

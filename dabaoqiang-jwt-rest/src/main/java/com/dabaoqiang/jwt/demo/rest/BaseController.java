package com.dabaoqiang.jwt.demo.rest;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.dabaoqiang.jwt.common.util.JwtTokenUtil;
import com.dabaoqiang.jwt.mybatis.domain.User;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xq
 */
public class BaseController {

    ThreadLocal<Long> userId = new ThreadLocal<Long>();


    @ModelAttribute
    public void initController(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userId.set(getUserIdByToken(request));
    }

    public Long getUserIdByToken(HttpServletRequest request) throws IOException {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            token = request.getParameter("token");
        }
        Claims claims = JwtTokenUtil.parseJWT(token);
        User subject = JSON.parseObject(claims.getSubject(), User.class);
        return subject.getId();
    }

    public Long getUserId() {
        return userId.get();
    }

}

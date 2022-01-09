package com.dabaoqiang.jwt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dabaoqiang.jwt.mybatis.domain.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xq
 * @since 2022-01-08
 */
public interface IUserService extends IService<User> {

    /**
     *
     * @param id
     * @return
     */
    User selectUser(Long id);



}

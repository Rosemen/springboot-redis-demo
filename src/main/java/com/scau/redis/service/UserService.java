package com.scau.redis.service;

import com.scau.redis.entity.User;

/**
 * UserService:
 *
 * @author chen
 * @date 2019/03/09
 */
public interface UserService {
    User getByName(String userName);
}

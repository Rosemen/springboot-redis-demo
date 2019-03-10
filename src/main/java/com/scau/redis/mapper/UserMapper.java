package com.scau.redis.mapper;

import com.scau.redis.entity.User;

/**
 * UserMapper:
 *
 * @author chen
 * @date 2019/03/09
 */
public interface UserMapper {
    User getByName(String userName);
}

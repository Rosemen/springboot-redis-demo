package com.scau.redis.service.impl;

import com.scau.redis.entity.User;
import com.scau.redis.mapper.UserMapper;
import com.scau.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserServiceImpl:
 *
 * @author chen
 * @date 2019/03/09
 */
@Service
@Transactional(rollbackFor = Exception.class)
@CacheConfig(cacheNames = "userCache")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable
    public User getByName(String userName) {
        User user = userMapper.getByName(userName);
        return user;
    }
}

package com.scau.redis.controller;

import com.scau.redis.entity.User;
import com.scau.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author chen
 * @date 2019/03/09
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getByName/{userName}")
    public User getByName(@PathVariable("userName") String userName){
        User user = userService.getByName(userName);
        return user;
    }

}

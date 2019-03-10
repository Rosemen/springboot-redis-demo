package com.scau.redis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * User
 *
 * @author chen
 * @date 2019/03/09
 */
@Data
public class User implements Serializable {
    private String userName;
    private String userPassword;
}

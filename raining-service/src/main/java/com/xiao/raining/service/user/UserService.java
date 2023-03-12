package com.xiao.raining.service.user;

import java.util.List;
import java.util.Map;

import com.xiao.raining.dao.query.user.UserQueryService;

/**
 * Author: xiaojl
 * Date:2023-03-12 00:31
 */
public class UserService {
    
    public List<Map<String, Object>> queryAllUsers() {
        return new UserQueryService().queryAllUsers();
    }
    
}
package com.javen.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.UserMapper;
import com.javen.model.User;
import com.javen.service.UserService;
  
  
@Service("userService")  
public class UserServiceImpl implements UserService {  
    @Resource  
    private UserMapper userDao;  
    
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }  
  
}
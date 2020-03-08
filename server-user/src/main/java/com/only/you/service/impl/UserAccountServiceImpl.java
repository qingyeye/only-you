package com.only.you.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.you.dao.ApiMapper;
import com.only.you.dao.UserAccountMapper;
import com.only.you.entity.User;
import com.only.you.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, User>implements UserAccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public User saveUser(User user) {

        User one = userAccountMapper.getUserByUserId(user);
        //检验数据库是否已经有该用户
        if (one != null){
         //有直接返回
            return one;
        }else{
        //没有插入数据库,返回主键
         int id = userAccountMapper.insertUserReturnId(user);
         user.setId(id);
         return user;
        }
    }
}

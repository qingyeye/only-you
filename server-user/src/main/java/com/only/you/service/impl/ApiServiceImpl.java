package com.only.you.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.you.dao.ApiMapper;
import com.only.you.entity.User;
import com.only.you.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl extends ServiceImpl<ApiMapper, User> implements ApiService {

    @Autowired
    private ApiMapper apiMapper;

    @Override
    public String test() {
        List<User> list = new ArrayList<>();
        this.saveBatch(list,100);
        return apiMapper.getTest();
    }
}

package com.only.you.service.impl;

import com.only.you.dao.ApiMapper;
import com.only.you.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiMapper apiMapper;

    @Override
    public void getTest(String id) {
         apiMapper.getTest(id);
    }
}

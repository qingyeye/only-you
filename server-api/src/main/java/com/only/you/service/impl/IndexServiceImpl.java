package com.only.you.service.impl;

import com.github.pagehelper.PageHelper;
import com.only.you.dao.IndexMapper;
import com.only.you.response.ServerResponse;
import com.only.you.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexMapper indexMapper;


    @Override
    public ServerResponse getIndexGoods(int pageId, int pageSize, int classifyType) {

        PageHelper.startPage(pageId,pageSize);
        // = indexMapper.getIndexGoods();

        return null;
    }
}

package com.only.you.service.jobservice.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.you.dao.DTKpullGoodsMapper;
import com.only.you.entity.jobentity.DTKResponse;
import com.only.you.entity.jobentity.DtkGoods;
import com.only.you.entity.jobentity.User;
import com.only.you.feign.HTKServerCilent;
import com.only.you.service.jobservice.DTKpullGoodsService;
import com.only.you.service.jobservice.httpsend.DTKHttpSend;
import com.only.you.utils.JsonUtils;
import com.only.you.utils.MyBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTKpullGoodsServiceImpl extends ServiceImpl<DTKpullGoodsMapper, DtkGoods> implements DTKpullGoodsService {

    private static final Logger logger = LoggerFactory.getLogger(DTKpullGoodsServiceImpl.class);

    @Autowired
    private HTKServerCilent htkServerCilent;

    @Autowired
    private DTKpullGoodsMapper dTKpullGoodsMapper;

    @Autowired
    private DTKHttpSend dTKHttpSend;
    
    @Override
    public void insertDTKGoods() {

        String pageId = "1";
        String pageSize = "200";
        while (true) {
            try {
                String result = dTKHttpSend.getGoodsList(pageSize, pageId);
                result = JSONObject.parseObject(result).getString("data");
                String pageid = JSONObject.parseObject(result).getString("pageId");
                JSONArray array = JSONArray.parseArray(JSONObject.parseObject(result).getString("list"));
                List<DTKResponse.DTKDataBean> dtkResponse = JsonUtils.getJsonToList(array.toJSONString(), DTKResponse.DTKDataBean.class);
                if (dtkResponse == null || dtkResponse.size() <= 0) {
                    break;
                }
                List<DtkGoods> dtkGoodsList = new ArrayList<>();
                for(DTKResponse.DTKDataBean bean:dtkResponse){
                    DtkGoods dtkGoods = new DtkGoods();
                     dtkGoods = MyBeanUtils.doToDto(bean, dtkGoods.getClass());
                    dtkGoodsList.add(dtkGoods);
                }

                this.saveBatch(dtkGoodsList);
                pageId = pageid;
            }catch (Exception e) {
                logger.error("获取商品列表错误"+e);
                break;
            }
        }
    }
}

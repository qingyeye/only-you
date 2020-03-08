package com.only.you.service.jobservice.impl;

import com.alibaba.fastjson.JSONObject;
import com.only.you.constant.Constant;
import com.only.you.entity.jobentity.DtkGoods;
import com.only.you.service.jobservice.HDKpullGoodsService;
import com.only.you.service.jobservice.httpsend.HDKHttpSend;
import com.only.you.utils.DateUtils;
import com.only.you.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TreeMap;

@Service
public class HDKpullGoodsServiceImpl implements HDKpullGoodsService {

    @Autowired
    private HDKHttpSend hDKHttpSend;
    @Override
    public void updateHdkPullGoods() {

        long min = 1;
        long back = 1000;
        int end = DateUtils.getHour(new Date());
        TreeMap<String, Object> data = new TreeMap<String, Object>();
        //如果结束时间是0点的情况,开始时间直接按照0点开始,如果结束时间非0点的情况,开始时间是1小时前
        data.put("start", end <= 0 ? 0:end-1);
        data.put("end", end);
        data.put("back", back);
        data.put("min_id", min);
        String str = hDKHttpSend.getHDKData(Constant.HDK_TIMING_ITEMS, data);
        JSONObject object = JSONObject.parseObject(str);
        DtkGoods response = JsonUtils.getJsonToBean(object.toJSONString(), DtkGoods.class);
        System.err.println("11111");
    }
}

package com.only.you.service.jobservice.httpsend;

import com.only.you.constant.Constant;
import com.only.you.entity.jobentity.DTKResponse;
import com.only.you.utils.DtkHttpUtils;
import com.only.you.utils.SignMD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;

@Service
@Slf4j
public class DTKHttpSend {

    /**
     * 大淘客商品列表
     *
     * @return
     */
    public String getGoodsList(String pageSize, String pageId) {

        TreeMap<String, String> paraMap = new TreeMap<>();
        paraMap.put("version", "v1.1.1");
        paraMap.put("appKey", Constant.DTK_APPKEY);
        paraMap.put("pageSize", pageSize);
        paraMap.put("pageId", pageId);
        paraMap.put("sign", SignMD5Util.getSignStr(paraMap, Constant.DTK_APPSECRET));
        List<DTKResponse.DTKDataBean> info = null;
        String result=null;
        try {
            result = DtkHttpUtils.sendGet(Constant.DTK_URL, paraMap);
        } catch (Exception e) {
            log.error("商品列表:",e);
        }
        return result;
    }
}

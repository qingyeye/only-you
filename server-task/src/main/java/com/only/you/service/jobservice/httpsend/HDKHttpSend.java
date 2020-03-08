package com.only.you.service.jobservice.httpsend;

import com.only.you.constant.Constant;
import com.only.you.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class HDKHttpSend {

    /**
     * 好单库
     * get请求
     * @param type 模块名称
     * @param param 参数
     * @return
     */
    public static String getHDKData(String type, Map<String, Object> param){
        StringBuilder builder = new StringBuilder();
        builder.append(Constant.HDK_URL);
        builder.append(type).append("/");
        builder.append("apikey/").append(Constant.HDK_APIKEY
        ).append("/");
        return HttpUtils.sendGet(builder.toString(), param);
    }
}

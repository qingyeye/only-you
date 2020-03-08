package com.only.you.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @projectName:openapi
 * @author:
 * @createTime: 2019/04/24 14:55
 * @description:
 */
public class DtkHttpUtils {

    private static final Logger log = LoggerFactory.getLogger(DtkHttpUtils.class);

    public static String doGet(String url) {
        CloseableHttpClient client = HttpClients.createDefault();
        URI uri = null;
        try {
            URL urlObj = new URL(url);//把string类型先转化为URL类型
            uri = urlObj.toURI();
        }catch (Exception e){
        }
        HttpGet httpGet = new HttpGet(uri.toString());
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            log.error("错误:",e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error("错误:",e);
                }
            }
            try {
                client.close();
            } catch (IOException e) {
                log.error("错误:",e);
            }
        }
        return null;
    }


    public static String sendGet(String getUrl,Map<String, String> paraMap){
        if(paraMap == null){
            paraMap = new HashMap<>();
        }
        paraMap= new TreeMap<>(paraMap);
        StringBuilder sb = new StringBuilder();
        paraMap.entrySet().stream().forEach(entry ->{
            sb.append(entry.getKey());
            sb.append("=");
            if(entry.getKey().equals("startTime") || entry.getKey().equals("endTime")){
                try {
                    sb.append(URLEncoder.encode(entry.getValue(),"utf-8"));
                }catch (Exception e){

                }

            }else{
                sb.append(entry.getValue());
            }

            sb.append("&");
        });
        getUrl = getUrl.contains("?")?getUrl:getUrl+"?";
        return doGet(getUrl+sb.toString());
    }
}

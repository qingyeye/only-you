package com.only.you.filter;
import com.only.you.entity.User;
import com.only.you.utils.Base64Utils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TokenVerifyFilter implements GlobalFilter, Ordered {

    private Logger logger = LoggerFactory.getLogger(TokenVerifyFilter.class);
    //这个列表是存放不需要验证的请求，可以放到配置 里面，从配置 文件中读取
    private List<String> whiteList = new ArrayList<>();
    @Autowired
    private RedisTemplate redisTemplate;
    @PostConstruct
    public void init(){
        whiteList.add("/account/index");
        whiteList.add("/account/login");//用户登陆
        whiteList.add("/v2/api-docs");//文档
        whiteList.add("/index/goodsList");//首页商品
    }
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String requestUri = exchange.getRequest().getURI().getPath();
        if(whiteList.contains(requestUri) || requestUri.endsWith("/js/") || requestUri.startsWith("/easyui/")){
            //在白名单内，不需要验证
            return chain.filter(exchange);
        }

        String shortToken = exchange.getRequest().getHeaders().getFirst("Authorization");
        String longToken = exchange.getRequest().getHeaders().getFirst("Authorization-x");

        if((shortToken == null || shortToken.isEmpty()) && (longToken == null || longToken.isEmpty())){

            logger.error("用户认证信息为空,返回获取认证信息失败");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        if (shortToken != null && StringUtils.isNotBlank(shortToken)){

            JWTUtil.TokenContent tokenContent = JWTUtil.getTokenContent(shortToken);
            String value =(String) redisTemplate.opsForValue().get(shortToken);
            if(value == null) {

                logger.error("用户认证信息为空,返回获取认证信息失败");
                exchange.getResponse().setStatusCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
                return exchange.getResponse().setComplete();
            } else {
                User longvalue =(User) redisTemplate.opsForValue().get(value);
                if(longvalue == null){
                    //这样是为防止别人冒充token
                    logger.error("token不一致或已过期");
                    exchange.getResponse().setStatusCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
                    return exchange.getResponse().setComplete();
                }
            }
        }
        if (longToken != null && StringUtils.isNotBlank(longToken)){

            User userInfo =(User) redisTemplate.opsForValue().get(longToken);
            if(userInfo == null) {

                logger.error("用户认证信息为空,返回获取认证信息失败");
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }else{
                //String string = Base64.decode(longToken).toString();
                String string = Base64Utils.getFromBASE64(longToken);
                String[] split = string.split(",");
                if (!userInfo.getUserId().equals(split[0])){
                    logger.error("用户认证信息为空,返回获取认证信息失败");
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            }
        }
        //token验证成功，放过
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 1;
    }
}

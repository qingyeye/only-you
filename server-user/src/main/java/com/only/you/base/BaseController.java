package com.only.you.base;

import com.only.you.entity.User;
import com.only.you.utils.JWTUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@RestController
public class BaseController {


    @Autowired
    private HttpServletRequest request;
    @Autowired
    private RedisTemplate redisTemplate;



    // 添加ModelAttribute后每次接口的请求会先执行这个
    @ModelAttribute
    public User getAppUser(HttpServletResponse response){
        String shortToken = request.getHeader("Authorization");
        String longToken = request.getHeader("Authorization-x");
        try {
            if (StringUtils.isBlank(shortToken)&&StringUtils.isBlank(longToken)){
                return null;
            }
            if (StringUtils.isNotBlank(shortToken)){
                String longTK = (String)redisTemplate.opsForValue().get(shortToken);
                User user = (User)redisTemplate.opsForValue().get(longTK);
                return user;
            }
            if (StringUtils.isNotBlank(longToken)){
                User user = (User)redisTemplate.opsForValue().get(longToken);
                //短token
                JWTUtil.TokenContent tokenContent = new JWTUtil.TokenContent();
                tokenContent.setUserId(longToken);
                 shortToken = JWTUtil.createToken(tokenContent, Duration.ofDays(7));
                redisTemplate.opsForValue().set(shortToken, longToken,8l, TimeUnit.DAYS);
                response.addHeader("Authorization",shortToken);
                redisTemplate.opsForValue().set(longToken, user,16l, TimeUnit.DAYS);
                return user;
            }
        }catch (Exception e){

            return null;
        }
        return null;
    }
}

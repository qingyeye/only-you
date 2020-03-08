package com.only.you.controller;

import com.alibaba.fastjson.JSONObject;
import com.only.you.base.BaseController;
import com.only.you.constant.Constant;
import com.only.you.entity.User;
import com.only.you.response.ServerResponse;
import com.only.you.service.UserAccountService;
import com.only.you.utils.Base64Utils;
import com.only.you.utils.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @ClassName: AccountController 
 * @Description: 账号管理模拟
 * @author: wang guang shuai
 * @date: 2020年3月4日 下午5:01:34
 */
@RestController
@RequestMapping("/account")
@Api(tags = "登陆模块")
public class UserAccountController extends BaseController {

    @Autowired
    private UserAccountService accountService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "首页跳转", notes = "首页",httpMethod = "GET")
    @RequestMapping("index")
    public String index()  {

        return "index";
    }
     /*  @RequestMapping("main")
    public String toMain() {
       return "main";
    }*/

    @ApiOperation(value = "账号登陆", notes = "用户登陆",httpMethod = "POST")
    @PostMapping(value = "login")
    public ServerResponse login(HttpServletResponse response,User user) {

        if (user == null){
            //用户信息为空
            return ServerResponse.createByErrorParamsNull();
        }else if (user != null &&(StringUtils.isBlank(user.getUserId())||StringUtils.isBlank(user.getUserName()))){
            //用户信息不全
            return ServerResponse.createByErrorParamsNotComplete();
        }
       user = this.accountService.saveUser(user);
        //长token
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(user.getUserId());
        stringBuffer.append(",");
        stringBuffer.append(Constant.SECRET_KEY);
       //String longToken = Base64.encode(stringBuffer.toString().getBytes()).toString();
        String longToken = Base64Utils.getBASE64(stringBuffer.toString());
        redisTemplate.opsForValue().set(longToken, user,16l, TimeUnit.DAYS);

        //短token
        JWTUtil.TokenContent tokenContent = new JWTUtil.TokenContent();
        tokenContent.setUserId(longToken);
        String shortToken = JWTUtil.createToken(tokenContent, Duration.ofDays(7));
        redisTemplate.opsForValue().set(shortToken, longToken,8l, TimeUnit.DAYS);

        //把token返回给客户端，让客户端在登陆成功 之后收到token，在以后的请求中都要将
        //token放到header中传到服务器，用于验证登陆
        response.addHeader("Authorization",shortToken);
        response.addHeader("Authorization-x", longToken);

        return ServerResponse.createBySuccess();
    }

    @ApiOperation(value = "校验Authorization", notes = "校验Authorization",httpMethod = "GET")
    @RequestMapping("/checkAuthorization")
    public ServerResponse getShortToken(HttpServletResponse response, HttpServletRequest request){

        String longToken = request.getHeader("Authorization-x");
        if (StringUtils.isNotBlank(longToken)){
            User user = (User)redisTemplate.opsForValue().get(longToken);

            JWTUtil.TokenContent tokenContent = new JWTUtil.TokenContent();
            tokenContent.setUserId(longToken);
            String shortToken = JWTUtil.createToken(tokenContent, Duration.ofDays(7));
            redisTemplate.opsForValue().set(shortToken, longToken,8l, TimeUnit.DAYS);
            response.addHeader("Authorization",shortToken);
            redisTemplate.opsForValue().set(longToken, user,16l, TimeUnit.DAYS);
        }else{
            response.setStatus(401);
        }
        return ServerResponse.createBySuccess();
    }






    @ApiOperation(value = "测试获取用户", notes = "首页",httpMethod = "GET")
    @RequestMapping("getAllAccount")
    public Object getAllAccount() {
        JSONObject userInfo = new JSONObject();
        userInfo.put("username", "xinyues");
        List<String> roles = new ArrayList<>();
        roles.add("Admin");
        roles.add("Dev");
        userInfo.put("roles", roles);
        return userInfo;
    }
}

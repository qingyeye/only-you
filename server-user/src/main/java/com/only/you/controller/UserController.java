package com.only.you.controller;

import com.only.you.entity.User;
import com.only.you.feign.UserFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户模块")
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/test/cilent")
    public User testCilent(){
        User byId = userFeignClient.findById(1l);
        return byId;
    }
    @ApiOperation(value = "计算+", notes = "加法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a",value = "数字a", paramType = "path",  required = true, dataType = "Long"),
            @ApiImplicitParam(name = "b", value = "数字b", paramType = "path", required = true, dataType = "Long")
    })
    @GetMapping("/{a}/{b}")
    public Integer get(@PathVariable Integer a, @PathVariable Integer b) {
        return a + b;
    }
}

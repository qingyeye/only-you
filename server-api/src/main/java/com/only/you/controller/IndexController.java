package com.only.you.controller;

import com.only.you.base.BaseController;
import com.only.you.entity.User;
import com.only.you.response.ServerResponse;
import com.only.you.service.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Api(tags = "首页模块")
@RequestMapping("/index")
public class IndexController extends BaseController {

    @Autowired
    private IndexService indexService;

    @ApiOperation(value = "获取首页商品", notes = "首页商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageId",value = "页码", paramType = "path",  required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "大小", paramType = "path", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "classifyType", value = "分类类型", paramType = "path", required = true, dataType = "Integer")
    })
   @GetMapping("/goodsList")
    public ServerResponse getIndexGoods(HttpServletResponse response,@RequestParam(defaultValue = "1") int pageId,  @RequestParam(defaultValue = "20")int pageSize,  @RequestParam(defaultValue = "1")int classifyType){

        User appUser = getAppUser(response);
        //用户登陆状态
        if (appUser != null){

          return  indexService.getIndexGoods(pageId,pageSize,classifyType);

        }else {

            return  indexService.getIndexGoods(pageId,pageSize,classifyType);
        }
    }
}

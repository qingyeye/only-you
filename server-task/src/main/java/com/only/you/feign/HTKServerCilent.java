package com.only.you.feign;

import com.only.you.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "SERVER-CILENT" , fallbackFactory = HystrixFactory.class)
@Component
public interface HTKServerCilent {

        @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
         User findById(@PathVariable("id") Long id);
}
